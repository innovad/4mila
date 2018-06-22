package com._4mila.backend.server.testdata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com._4mila.backend.model.clazz.Clazz;
import com._4mila.backend.model.clazz.EventClazz;
import com._4mila.backend.model.control.Control;
import com._4mila.backend.model.course.Course;
import com._4mila.backend.model.course.CourseControl;
import com._4mila.backend.model.event.Event;
import com._4mila.backend.service.AbstractDatabaseService;
import com._4mila.backend.service.clazz.ClazzDatabaseService;
import com._4mila.backend.service.clazz.EventClazzDatabaseService;
import com._4mila.backend.service.control.ControlDatabaseService;
import com._4mila.backend.service.course.CourseControlDatabaseService;
import com._4mila.backend.service.course.CourseDatabaseService;
import com._4mila.backend.service.event.EventDatabaseService;
import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

public class TestDataService extends AbstractDatabaseService {

	private static final Logger logger = LoggerFactory.getLogger(TestDataService.class);

	@Inject
	EventDatabaseService eventDatabaseService;

	@Inject
	ControlDatabaseService controlDatabaseService;
	
	@Inject
	CourseDatabaseService courseDatabaseService;
	
	@Inject
	ClazzDatabaseService clazzDatabaseService;
	
	@Inject
	EventClazzDatabaseService eventClazzDatabaseService;
	
	@Inject
	CourseControlDatabaseService courseControlDatabaseService;

	@Transactional
	public void create() {
		if (eventDatabaseService.list().size() > 0) {
			logger.info("No Test Data");
			return;
		}

		Event event1 = createTestEvent("Pfaffenholz-OL");
		Event event2 = createTestEvent("Swiss Championships");

		Control e1control31 = createTestControl(event1, "31");
		Control e1control32 = createTestControl(event1, "32");
		Control e1control33 = createTestControl(event1, "33");
		Control e1control34 = createTestControl(event1, "34");
		Control e1control35 = createTestControl(event1, "35");

		Control e2control31 = createTestControl(event2, "31");
		Control e2control99 = createTestControl(event2, "99");
		Control e2control100 = createTestControl(event2, "100");
		Control e2control101 = createTestControl(event2, "101");
		Control e2control102 = createTestControl(event2, "102");
		
		Course courseA = createTestCourse(event1, "Course A");
		Course courseB = createTestCourse(event1, "Course B");
		Course courseC = createTestCourse(event1, "Course C");

		Course courseLong = createTestCourse(event2, "Long");
		Course courseShort = createTestCourse(event2, "Short");
		
		Clazz he = createTestClass("HE");
		Clazz de = createTestClass("DE");
		Clazz h20 = createTestClass("H20");
		Clazz d20 = createTestClass("D20");
		
		createTestEventClass(event1, he, courseA);
		createTestEventClass(event1, de, courseB);
		createTestEventClass(event2, he, courseLong);
		createTestEventClass(event2, de, courseLong);
		createTestEventClass(event2, h20, courseShort);
		createTestEventClass(event2, d20, courseShort);
		
		createTestCourseControl(1, courseA, e1control31);
		createTestCourseControl(2, courseA, e1control32);
		createTestCourseControl(1, courseB, e1control31);
		createTestCourseControl(1, courseC, e1control32);
		createTestCourseControl(2, courseC, e1control33);
		createTestCourseControl(3, courseC, e1control34);
		createTestCourseControl(4, courseC, e1control35);

		createTestCourseControl(1, courseShort, e2control31);
		createTestCourseControl(1, courseShort, e2control99);
		createTestCourseControl(1, courseShort, e2control100);
				
		createTestCourseControl(1, courseLong, e2control100);
		createTestCourseControl(2, courseLong, e2control101);
		createTestCourseControl(3, courseLong, e2control102);
		
		logger.info("Test Data created.");
	}

	private Event createTestEvent(String name) {
		Event event = new Event();
		event.setName(name);
		eventDatabaseService.create(event);
		return event;
	}

	private Control createTestControl(Event event, String id) {
		Control control = new Control();
		control.setEvent(event);
		control.setId(id);
		controlDatabaseService.create(control);
		return control;
	}

	private Course createTestCourse(Event event, String name) {
		Course course = new Course();
		course.setEvent(event);
		course.setName(name);
		courseDatabaseService.create(course);
		return course;
	}
	
	private Clazz createTestClass(String name) {
		Clazz clazz = new Clazz();
		clazz.setName(name);
		clazzDatabaseService.create(clazz);
		return clazz;
	}
	
	private EventClazz createTestEventClass(Event event, Clazz clazz, Course course) {
		EventClazz eventClass = new EventClazz();
		eventClass.setEvent(event);
		eventClass.setClazz(clazz);
		eventClass.setCourse(course);
		eventClazzDatabaseService.create(eventClass);
		return eventClass;
	}
	
	private CourseControl createTestCourseControl(long sortOrder, Course course, Control control) {
		CourseControl courseControl = new CourseControl();
		courseControl.setCourse(course);
		courseControl.setControl(control);
		courseControl.setSortOrder(sortOrder);
		courseControlDatabaseService.create(courseControl);
		return courseControl;
	}
		
}