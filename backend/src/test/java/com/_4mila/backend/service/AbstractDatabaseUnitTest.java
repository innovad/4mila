package com._4mila.backend.service;

import org.junit.BeforeClass;

import com._4mila.backend.server.Database;

public abstract class AbstractDatabaseUnitTest extends AbstractUnitTest {

	@BeforeClass
	public static void beforeClass() throws Exception {
		getInjector().getInstance(Database.class).init("9996", "9997", false);
	}

}
