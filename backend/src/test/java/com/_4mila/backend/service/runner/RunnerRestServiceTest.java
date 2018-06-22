package com._4mila.backend.service.runner;

import com._4mila.backend.model.runner.Runner;
import com._4mila.backend.service.AbstractCrudRestServiceTest;

public class RunnerRestServiceTest extends AbstractCrudRestServiceTest<Runner, Long> {

	@Override
	protected Class<?> getService() {
		return RunnerRestService.class;
	}

	@Override
	protected Class<Runner> getEntityClass() {
		return Runner.class;
	}
	
}
