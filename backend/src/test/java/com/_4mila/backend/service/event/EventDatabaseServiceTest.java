package com._4mila.backend.service.event;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com._4mila.backend.model.event.Event;
import com._4mila.backend.service.AbstractUnitTest;

public class EventDatabaseServiceTest extends AbstractUnitTest {

	@Test
	public void testService() throws Exception {
		EventDatabaseService svc = getInjector().getInstance(EventDatabaseService.class);
		assertNotNull(svc);

		Event event1 = new Event();
		event1 = svc.create(event1);
		
		assertNotNull(event1.getKey());
	}

}