package com._4mila.backend.service.runner.csv;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.AfterClass;
import org.junit.Test;

import com._4mila.backend.model.ecard.Ecard;
import com._4mila.backend.model.runner.Runner;
import com._4mila.backend.model.runner.csv.RunnerImport;
import com._4mila.backend.service.AbstractCrudRestServiceTest;
import com._4mila.backend.service.ecard.EcardDatabaseService;
import com._4mila.backend.service.runner.RunnerDatabaseService;


public class RunnerImportRestServiceTest extends AbstractCrudRestServiceTest<RunnerImport, Long> {

	@Override
	protected Class<?> getService() {
		return RunnerImportRestService.class;
	}

	@Override
	protected Class<RunnerImport> getEntityClass() {
		return RunnerImport.class;
	}
		
	@Test
	public void testMultipleUpload() throws Exception {
		RunnerDatabaseService runnerDatabaseService = getInjector().getInstance(RunnerDatabaseService.class);
		EcardDatabaseService ecardDatabaseService = getInjector().getInstance(EcardDatabaseService.class);
		int initialRunnerCount = runnerDatabaseService.list().size();
		int initialEcardCount = ecardDatabaseService.list().size();
		
		String jsonResult = testPost("/upload", "runner.csv");
		assertNotNull("fileKey", jsonResult);
		assertEquals(initialRunnerCount + 17, runnerDatabaseService.list().size());
		assertEquals(initialEcardCount + 16, ecardDatabaseService.list().size());
		
		jsonResult = testPost("/upload", "runner.csv");
		assertNotNull("fileKey", jsonResult);
		assertEquals(initialRunnerCount + 17, runnerDatabaseService.list().size());
		assertEquals(initialEcardCount + 16, ecardDatabaseService.list().size());
	}
	
	@AfterClass
	public static void cleanup() {
		RunnerDatabaseService runnerDatabaseService = getInjector().getInstance(RunnerDatabaseService.class);
		EcardDatabaseService ecardDatabaseService = getInjector().getInstance(EcardDatabaseService.class);
		
		for (Runner runner : runnerDatabaseService.list()) {
			runnerDatabaseService.delete(runner);
		}
		for (Ecard ecard : ecardDatabaseService.list()) {
			ecardDatabaseService.delete(ecard);
		}
	}
	
}
