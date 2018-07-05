package com._4mila.backend.service.race;

import com._4mila.backend.model.race.Race;
import com._4mila.backend.service.AbstractCrudRestServiceTest;

public class RaceRestServiceTest extends AbstractCrudRestServiceTest<Race, Long> {

	@Override
	protected Class<?> getService() {
		return RaceRestService.class;
	}

	@Override
	protected Class<Race> getEntityClass() {
		return Race.class;
	}
	
}
