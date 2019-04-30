package com._4mila.backend.service.runner.csv;

import com._4mila.backend.model.runner.csv.RunnerImport;
import com._4mila.backend.service.AbstractCrudDatabaseServiceTest;

public class RunnerImportDatabaseServiceTest extends AbstractCrudDatabaseServiceTest<RunnerImport, Long> {

	@Override
	protected Class<?> getService() {
		return RunnerImportDatabaseService.class;
	}

	@Override
	protected Class<RunnerImport> getEntity() {
		return RunnerImport.class;
	}
	

}