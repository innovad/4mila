package com._4mila.backend.service.runner;

import com._4mila.backend.model.runner.Runner;
import com._4mila.backend.service.AbstractCrudDatabaseServiceTest;

public class RunnerDatabaseServiceTest extends AbstractCrudDatabaseServiceTest<Runner, Long> {

	@Override
	protected Class<?> getService() {
		return RunnerDatabaseService.class;
	}

	@Override
	protected Class<Runner> getEntity() {
		return Runner.class;
	}
	

}