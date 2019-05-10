package com._4mila.backend.service.course.iof2;

import static spark.Spark.post;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com._4mila.backend.model.control.Control;
import com._4mila.backend.model.course.Course;
import com._4mila.backend.model.course.iof2.CourseImport;
import com._4mila.backend.model.event.Event;
import com._4mila.backend.service.AbstractCrudRestService;
import com._4mila.backend.service.PathListEntry;
import com._4mila.backend.service.control.ControlDatabaseService;
import com._4mila.backend.service.course.CourseDatabaseService;
import com._4mila.backend.service.course.iof2.xml.CourseData;
import com._4mila.backend.service.course.iof2.xml.XmlControl;
import com._4mila.backend.service.course.iof2.xml.XmlCourse;
import com._4mila.backend.service.event.EventDatabaseService;
import com._4mila.backend.service.exception.BackendValidationException;
import com.google.common.primitives.Longs;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class CourseImportRestService extends AbstractCrudRestService<CourseImport, Long, CourseImportDatabaseService> {

	private static final Logger logger = LoggerFactory.getLogger(CourseImportRestService.class);

	@Inject
	CourseDatabaseService courseDatabaseService;

	@Inject
	ControlDatabaseService controlDatabaseService;

	@Inject
	EventDatabaseService eventDatabaseService;

	@Inject
	public CourseImportRestService(Injector injector) {
		super(injector, CourseImportDatabaseService.class);
	}

	@Override
	public void initPost() {
		super.initPost();

		post("services/upload/event/:eventKey/course", (req, res) -> {
			Long eventKey = Longs.tryParse(req.params("eventKey"));
			Event event = eventDatabaseService.read(eventKey); 
			req.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement("/temp"));
			Part part = req.raw().getPart("upload");
			try (InputStream is = part.getInputStream()) {
				// Get existing courses
				List<Course> existingCourses = courseDatabaseService.list(courseDatabaseService.new EventFilter(eventKey));
				HashMap<String, Course> existingCourseLookup = new HashMap<>();
				for (Course existingCourse : existingCourses) {
					existingCourseLookup.put(existingCourse.getName(), existingCourse);
				}

				// Get existing controls
				List<Control> existingControls = controlDatabaseService.list(controlDatabaseService.new EventFilter(eventKey));
				HashMap<String, Control> existingControlLookup = new HashMap<>();
				for (Control existingControl : existingControls) {
					existingControlLookup.put(existingControl.getId(), existingControl);
				}

				// Read file
				CourseData root = XMLUtility.unmarshal(part.getInputStream(), new CourseData(), false);
				logger.info("upload course");

				for (XmlControl control : root.getControl()) {
					Control newControl = existingControlLookup.get(control.getControlCode().getvalue());
					if (newControl == null) {
						newControl = new Control();
						newControl.setId(control.getControlCode().getvalue());
						newControl.setEvent(event);
						controlDatabaseService.create(newControl);
					}
				}

				for (XmlCourse course : root.getCourse()) {
					Course newCourse = existingCourseLookup.get(course.getCourseName());
					if (newCourse == null) {
						newCourse = new Course();
						newCourse.setName(course.getCourseName());
						newCourse.setEvent(event);
						courseDatabaseService.create(newCourse);
					}
				}

			} catch (IOException e) {
				logger.error("File upload failed", e);
				throw new BackendValidationException("FileUploadError");
			}
			PathListEntry<String> result = new PathListEntry<>();
			result.setKey(UUID.randomUUID().toString(), "fileKey");
			return result;
		}, getJsonTransformer());

	}

}
