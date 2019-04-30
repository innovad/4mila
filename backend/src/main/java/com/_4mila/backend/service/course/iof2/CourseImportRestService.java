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

import com._4mila.backend.model.course.iof2.CourseImport;
import com._4mila.backend.model.event.Event;
import com._4mila.backend.service.AbstractCrudRestService;
import com._4mila.backend.service.PathListEntry;
import com._4mila.backend.service.course.CourseDatabaseService;
import com._4mila.backend.service.course.iof2.xml.Course;
import com._4mila.backend.service.course.iof2.xml.CourseData;
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
	EventDatabaseService eventDatabaseService;

	@Inject
	public CourseImportRestService(Injector injector) {
		super(injector, CourseImportDatabaseService.class);
	}

	@Override
	public void initPost() {
		super.initPost();

		post("services/upload/event/:eventKey/course", (req, res) -> {
			Long eventNr = Longs.tryParse(req.params("eventKey"));
			Event event = eventDatabaseService.read(eventNr); // TODO path should replace :eventKey in fileUpload Element
			req.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement("/temp"));
			Part part = req.raw().getPart("upload");
			try (InputStream is = part.getInputStream()) {
				// Get existing courses
				// TODO should be event-dependent
				List<com._4mila.backend.model.course.Course> existingCourses = courseDatabaseService.list();
				HashMap<String, com._4mila.backend.model.course.Course> existingRunnerLookup = new HashMap<>();
				for (com._4mila.backend.model.course.Course existingCourse : existingCourses) {
					existingRunnerLookup.put(existingCourse.getName(), existingCourse);
				}

				// Read file
				CourseData root = XMLUtility.unmarshal(part.getInputStream(), new CourseData(), false);
				logger.info("upload course");
				logger.info("courses: " + root.getCourse().size());

				for (Course course : root.getCourse()) {
					com._4mila.backend.model.course.Course newCourse = existingRunnerLookup.get(course.getCourseName());
					if (newCourse == null) {
						newCourse = new com._4mila.backend.model.course.Course();
						newCourse.setName(course.getCourseName());
						newCourse.setEvent(event);
						courseDatabaseService.create(newCourse);
					} else {
						newCourse.setName(course.getCourseName());
						newCourse.setEvent(event);
						courseDatabaseService.update(newCourse);
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
