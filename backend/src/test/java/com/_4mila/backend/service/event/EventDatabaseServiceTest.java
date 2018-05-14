package com._4mila.backend.service.event;

import com._4mila.backend.model.event.Event;
import com._4mila.backend.service.AbstractCrudDatabaseServiceTest;

public class EventDatabaseServiceTest extends AbstractCrudDatabaseServiceTest<Event, Long> {

	@Override
	protected Class<?> getService() {
		return EventDatabaseService.class;
	}

	@Override
	protected Class<Event> getEntity() {
		return Event.class;
	}
	

}