package com._4mila.backend.service.race;

import com._4mila.backend.model.race.Race;
import com._4mila.backend.service.AbstractCrudDatabaseServiceTest;

public class RaceDatabaseServiceTest extends AbstractCrudDatabaseServiceTest<Race, Long> {

	@Override
	protected Class<?> getService() {
		return RaceDatabaseService.class;
	}

	@Override
	protected Class<Race> getEntity() {
		return Race.class;
	}
	

}