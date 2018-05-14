package com._4mila.backend.service.control;

import com._4mila.backend.service.AbstractCrudRestService;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class ControlRestService extends AbstractCrudRestService<ControlDatabaseService, Long> {

	@Inject
	public ControlRestService(Injector injector) {
		super(injector, ControlDatabaseService.class);
	}

}
