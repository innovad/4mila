package com._4mila.backend.service.race;

import com._4mila.backend.model.race.Race;
import com._4mila.backend.service.AbstractCrudRestService;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class RaceRestService extends AbstractCrudRestService<Race, Long, RaceDatabaseService> {

	@Inject
	public RaceRestService(Injector injector) {
		super(injector, RaceDatabaseService.class);
	}

}
