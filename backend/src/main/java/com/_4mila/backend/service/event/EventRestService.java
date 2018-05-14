package com._4mila.backend.service.event;

import com._4mila.backend.service.AbstractCrudRestService;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class EventRestService extends AbstractCrudRestService<EventDatabaseService, Long> {

	@Inject
	public EventRestService(Injector injector) {
		super(injector, EventDatabaseService.class);
	}

}
