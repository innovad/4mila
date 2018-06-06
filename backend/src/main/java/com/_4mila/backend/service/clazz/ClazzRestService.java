package com._4mila.backend.service.clazz;

import com._4mila.backend.model.clazz.Clazz;
import com._4mila.backend.service.AbstractCrudRestService;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class ClazzRestService extends AbstractCrudRestService<Clazz, Long> {

	@Inject
	public ClazzRestService(Injector injector) {
		super(injector, ClazzDatabaseService.class);
	}

}
