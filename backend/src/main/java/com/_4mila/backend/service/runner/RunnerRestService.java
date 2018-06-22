package com._4mila.backend.service.runner;

import com._4mila.backend.model.clazz.Clazz;
import com._4mila.backend.service.AbstractCrudRestService;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class RunnerRestService extends AbstractCrudRestService<Clazz, Long> {

	@Inject
	public RunnerRestService(Injector injector) {
		super(injector, RunnerDatabaseService.class);
	}

}
