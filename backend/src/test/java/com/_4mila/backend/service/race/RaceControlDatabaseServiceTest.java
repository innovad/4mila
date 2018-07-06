package com._4mila.backend.service.race;

import com._4mila.backend.model.race.RaceControl;
import com._4mila.backend.service.AbstractCrudDatabaseServiceTest;

public class RaceControlDatabaseServiceTest extends AbstractCrudDatabaseServiceTest<RaceControl, Long> {

	@Override
	protected Class<?> getService() {
		return RaceControlDatabaseService.class;
	}

	@Override
	protected Class<RaceControl> getEntity() {
		return RaceControl.class;
	}
	

}