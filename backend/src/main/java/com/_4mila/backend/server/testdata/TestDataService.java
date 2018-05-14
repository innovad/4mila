package com._4mila.backend.server.testdata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com._4mila.backend.model.event.Event;
import com._4mila.backend.service.AbstractDatabaseService;
import com._4mila.backend.service.event.EventDatabaseService;
import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

public class TestDataService extends AbstractDatabaseService {

	private static final Logger logger = LoggerFactory.getLogger(TestDataService.class);

	@Inject
	EventDatabaseService eventDatabaseService;

	@Transactional
	public void create() {
		if (eventDatabaseService.list().size() > 0) {
			logger.info("No Test Data");
			return;
		}
		
		createTestEvent("Pfaffenholz-OL");
		
		logger.info("Test Data created.");
	}

	private Event createTestEvent(String name) {
		Event event = new Event();
		event.setName(name);
		eventDatabaseService.create(event);
		return event;
	}

}