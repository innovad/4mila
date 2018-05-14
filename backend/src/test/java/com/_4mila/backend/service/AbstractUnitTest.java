package com._4mila.backend.service;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import com._4mila.backend.server.Database;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.jpa.JpaPersistModule;

public class AbstractUnitTest {

	private static final JpaPersistModule persistModule = new JpaPersistModule("AssessmentTool");
	private static Injector injector;

	@BeforeClass
	public static void beforeClass() {
		if (injector == null) {
			injector = Guice.createInjector(persistModule);
			injector.getInstance(Database.class).init("9998", "9999", false);
		}
	}

	@AfterClass
	public static void afterClass() {

	}

	public Injector getInjector() {
		return injector;
	}

}
