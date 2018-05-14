package com._4mila.backend.service.event;

import com._4mila.backend.model.event.Event;
import com._4mila.backend.service.AbstractCrudRestServiceTest;

public class EventRestServiceTest extends AbstractCrudRestServiceTest<Event, Long> {

	@Override
	protected Class<?> getService() {
		return EventRestService.class;
	}

	@Override
	protected Class<Event> getEntityClass() {
		return Event.class;
	}
	
}
