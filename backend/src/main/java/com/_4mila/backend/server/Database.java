package com._4mila.backend.server;

import java.sql.SQLException;

import org.h2.tools.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com._4mila.backend.Main;
import com._4mila.backend.server.testdata.TestDataService;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;

@Singleton
public class Database {

	private static final Logger logger = LoggerFactory.getLogger(Main.class);
	private boolean started = false;

	@Inject
	Injector injector;

	public synchronized void init(String dbPort, String webPort, boolean createTestData) {
		if (started) {
			return;
		}
		injector.getInstance(GuicePersistenceInitializer.class); // init jpa
		try {
			Server webServer = org.h2.tools.Server.createWebServer("-webPort", webPort);
			webServer.start();
			logger.info("Started Web server on " + webServer.getURL());
			Server tcpServer = org.h2.tools.Server.createTcpServer("-tcpAllowOthers", "-tcpPort", dbPort);
			tcpServer.start();
			logger.info("Started TCP server on " + tcpServer.getURL());
		} catch (SQLException e) {
			logger.error("error starting database", e);
		}
		if (createTestData) {
			injector.getInstance(TestDataService.class).create();
		}
		started = true;
	}

}
