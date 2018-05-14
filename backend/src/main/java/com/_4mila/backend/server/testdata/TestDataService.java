package com._4mila.backend.server.testdata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com._4mila.backend.model.control.Control;
import com._4mila.backend.model.event.Event;
import com._4mila.backend.service.AbstractDatabaseService;
import com._4mila.backend.service.control.ControlDatabaseService;
import com._4mila.backend.service.event.EventDatabaseService;
import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

public class TestDataService extends AbstractDatabaseService {

	private static final Logger logger = LoggerFactory.getLogger(TestDataService.class);

	@Inject
	EventDatabaseService eventDatabaseService;

	@Inject
	ControlDatabaseService controlDatabaseService;

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

		logger.info("Test Data created.");
	}

	private Event createTestEvent(String name) {
		Event event = new Event();
		event.setName(name);
		eventDatabaseService.create(event);
		return event;
	}

	private Event createTestControl(Event event, String id) {
		Control control = new Control();
		control.setEvent(event);
		control.setId(id);
		controlDatabaseService.create(control);
		return event;
	}

}