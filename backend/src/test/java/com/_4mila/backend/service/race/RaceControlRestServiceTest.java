package com._4mila.backend.service.race;

import com._4mila.backend.model.race.RaceControl;
import com._4mila.backend.service.AbstractCrudRestServiceTest;

public class RaceControlRestServiceTest extends AbstractCrudRestServiceTest<RaceControl, Long> {

	@Override
	protected Class<?> getService() {
		return RaceControlRestService.class;
	}

	@Override
	protected Class<RaceControl> getEntityClass() {
		return RaceControl.class;
	}
	
}
