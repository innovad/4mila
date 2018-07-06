package com._4mila.backend.service.race;

import com._4mila.backend.model.race.RaceControl;
import com._4mila.backend.service.AbstractCrudRestService;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class RaceControlRestService extends AbstractCrudRestService<RaceControl, Long, RaceControlDatabaseService> {

	@Inject
	public RaceControlRestService(Injector injector) {
		super(injector, RaceControlDatabaseService.class);
	}

}
