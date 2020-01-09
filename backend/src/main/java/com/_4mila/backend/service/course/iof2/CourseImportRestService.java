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
import com._4mila.backend.model.control.ControlType;
import com._4mila.backend.model.course.Course;
import com._4mila.backend.model.course.CourseControl;
import com._4mila.backend.model.course.iof2.CourseImport;
import com._4mila.backend.model.event.Event;
import com._4mila.backend.service.AbstractCrudRestService;
import com._4mila.backend.service.PathListEntry;
import com._4mila.backend.service.control.ControlDatabaseService;
import com._4mila.backend.service.course.CourseControlDatabaseService;
import com._4mila.backend.service.course.CourseDatabaseService;
import com._4mila.backend.service.course.iof2.xml.ControlCode;
import com._4mila.backend.service.course.iof2.xml.CourseData;
import com._4mila.backend.service.course.iof2.xml.CourseVariation;
import com._4mila.backend.service.course.iof2.xml.FinishPoint;
import com._4mila.backend.service.course.iof2.xml.FinishPointCode;
import com._4mila.backend.service.course.iof2.xml.StartPoint;
import com._4mila.backend.service.course.iof2.xml.StartPointCode;
import com._4mila.backend.service.course.iof2.xml.XmlControl;
import com._4mila.backend.service.course.iof2.xml.XmlCourse;
import com._4mila.backend.service.course.iof2.xml.XmlCourseControl;
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
	CourseControlDatabaseService courseControlDatabaseService;

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

				// Starts
				for (StartPoint control : root.getStartPoint()) {
					Control newControl = existingControlLookup.get(control.getStartPointCode().getvalue());
					if (newControl == null) {
						newControl = new Control();
						newControl.setId(control.getStartPointCode().getvalue());
						newControl.setEvent(event);
						newControl.setType(ControlType.start);
						controlDatabaseService.create(newControl);
						existingControlLookup.put(newControl.getId(), newControl);
					}
				}

				// Finish
				for (FinishPoint control : root.getFinishPoint()) {
					Control newControl = existingControlLookup.get(control.getFinishPointCode().getvalue());
					if (newControl == null) {
						newControl = new Control();
						newControl.setId(control.getFinishPointCode().getvalue());
						newControl.setEvent(event);
						newControl.setType(ControlType.finish);
						controlDatabaseService.create(newControl);
						existingControlLookup.put(newControl.getId(), newControl);
					}
				}

				// Controls
				for (XmlControl control : root.getControl()) {
					Control newControl = existingControlLookup.get(control.getControlCode().getvalue());
					if (newControl == null) {
						newControl = new Control();
						newControl.setId(control.getControlCode().getvalue());
						newControl.setEvent(event);
						newControl.setType(ControlType.control);
						controlDatabaseService.create(newControl);
						existingControlLookup.put(newControl.getId(), newControl);
					}
				}

				// Courses
				for (XmlCourse course : root.getCourse()) {
					Course newCourse = existingCourseLookup.get(course.getCourseName());
					if (newCourse == null) {
						newCourse = new Course();
						newCourse.setName(course.getCourseName());
						newCourse.setEvent(event);
						courseDatabaseService.create(newCourse);
					} else {
						// delete existing controls
						courseDatabaseService.deleteCourseControls(newCourse);
					}

					// Course Variation
					// no real variation support yet
					for (CourseVariation variation : course.getCourseVariation()) {
						long lastControlSortCode = -1;

						if (variation.getCourseLength() != null) {
							newCourse.setLength(variation.getCourseLength().getvalue());
						}
						if (variation.getCourseClimb() != null) {
							newCourse.setClimb(variation.getCourseClimb().getvalue());
						}

						// Start
						for (Object startPointCodeOrStartPoint : variation.getStartPointCodeOrStartPoint()) {
							if (startPointCodeOrStartPoint instanceof StartPointCode) {
								StartPointCode controlCode = (StartPointCode) startPointCodeOrStartPoint;
								lastControlSortCode++;
								Control control = existingControlLookup.get(controlCode.getvalue());
								createCourseControl(newCourse, control, lastControlSortCode);
							}
						}

						// Course Control
						for (XmlCourseControl courseControl : variation.getCourseControl()) {
							Long sequenceNr = Longs.tryParse(courseControl.getSequence());
							if (sequenceNr != null) {
								lastControlSortCode = sequenceNr;
							} else {
								lastControlSortCode++;
							}
							for (Object controlCodeOrControl : courseControl.getControlCodeOrControl()) {
								if (controlCodeOrControl instanceof ControlCode) {
									ControlCode controlCode = (ControlCode) controlCodeOrControl;
									Control control = existingControlLookup.get(controlCode.getvalue());
									createCourseControl(newCourse, control, lastControlSortCode);
								}
							}
						}

						// Finish
						for (Object finishPointCodeOrFinishPoint : variation.getFinishPointCodeOrFinishPoint()) {
							if (finishPointCodeOrFinishPoint instanceof FinishPointCode) {
								FinishPointCode controlCode = (FinishPointCode) finishPointCodeOrFinishPoint;
								lastControlSortCode++;
								Control control = existingControlLookup.get(controlCode.getvalue());
								createCourseControl(newCourse, control, lastControlSortCode);
							}
						}

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
	
	private CourseControl createCourseControl(Course course, Control control, long sortOrder) {
		CourseControl newCourseControl = new CourseControl();
		newCourseControl.setCourse(course);
		newCourseControl.setControl(control);
		newCourseControl.setSortOrder(sortOrder);
		return courseControlDatabaseService.create(newCourseControl);
	}

}
