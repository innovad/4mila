package com._4mila.backend.server.testdata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com._4mila.backend.model.control.Control;
import com._4mila.backend.model.course.Course;
import com._4mila.backend.model.event.Event;
import com._4mila.backend.service.AbstractDatabaseService;
import com._4mila.backend.service.control.ControlDatabaseService;
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

	@Transactional
	public void create() {
		if (eventDatabaseService.list().size() > 0) {
			logger.info("No Test Data");
			return;
		}

		Event event1 = createTestEvent("Pfaffenholz-OL");
		Event event2 = createTestEvent("Swiss Championships");

		createTestControl(event1, "31");
		createTestControl(event1, "32");
		createTestControl(event1, "33");
		createTestControl(event1, "34");
		createTestControl(event1, "35");

		createTestControl(event2, "31");
		createTestControl(event2, "99");
		createTestControl(event2, "100");
		createTestControl(event2, "101");
		createTestControl(event2, "102");
		
		createTestCourse(event1, "Course A");
		createTestCourse(event1, "Course B");
		createTestCourse(event1, "Course C");

		createTestCourse(event2, "Long");
		createTestCourse(event2, "Short");
		
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
	
}