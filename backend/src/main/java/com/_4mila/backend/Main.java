package com._4mila.backend;

import static spark.Spark.before;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.staticFiles;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Properties;

import org.hibernate.dialect.PostgreSQL95Dialect;
import org.postgresql.Driver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com._4mila.backend.server.CorsHeaders;
import com._4mila.backend.server.Database;
import com._4mila.backend.server.EnvironmentUtility;
import com._4mila.backend.service.control.ControlRestService;
import com._4mila.backend.service.course.CourseRestService;
import com._4mila.backend.service.event.EventRestService;
import com._4mila.backend.service.exception.ExceptionRestService;
import com._4mila.backend.service.language.LanguageUtility;
import com._4mila.backend.service.user.UserRestService;
import com.google.common.base.Strings;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.jpa.JpaPersistModule;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

public class Main {
	private static final String HEROKU_PORT = "PORT";
	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	private static final JpaPersistModule persistModule = new JpaPersistModule("AssessmentTool");
	private static Injector injector;

	public static void main(String[] args) {
		initFrontend();
		initDatabase();
		initServer();

		// Cache
		before((request, response) -> {
			response.header("cache-control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
			response.header("pragma", "no-cache"); // HTTP 1.0
			response.header("expires", "0"); // HTTP 1.0 proxies
		});

		// Language
		before("services/*", (request, response) -> {
			String languageCode = request.queryParams("languageCode");
			if (languageCode != null) {
				LanguageUtility.setUserLanguage(languageCode);
			}
		});

		// Wake Up Ping (Heroku)
		get("services/ping", (req, res) -> {
			Jws<Claims> jwt = JwtUtility.getJsonWebToken(req);
			String userId = null;
			if (jwt != null) {
				userId = jwt.getBody().getSubject();
			}
			String defaultUser = req.url().contains("localhost") ? "chat" : "";
			String languageCode = LanguageUtility.getUserLanguage().getCode();
			return "{ \"status\": \"ok\", \"userId\": \"" + (userId == null ? defaultUser : userId) + "\", \"languageCode\": \"" + languageCode + "\",\"version\": \"" + new Version().getVersion() + "\"}";
		});

		// Services
		injector.getInstance(UserRestService.class).init();
		injector.getInstance(EventRestService.class).init();
		injector.getInstance(ControlRestService.class).init();
		injector.getInstance(CourseRestService.class).init();

		// Exception Handler
		injector.getInstance(ExceptionRestService.class).init();

		logger.info("4mila Backend running on localhost:" + getHerokuAssignedPort());
	}

	private static void initFrontend() {
		try {
			File frontendDirectory = new File("../frontend/dist");
			if (!frontendDirectory.isDirectory()) {
				frontendDirectory = new File("frontend/dist");
			}
			staticFiles.externalLocation(frontendDirectory.getCanonicalPath());
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Could not resolve frontend files");
			System.exit(1);
		}
	}

	private static void initDatabase() {
		Properties properties = new Properties();
		if (!Strings.isNullOrEmpty(EnvironmentUtility.getPropertyOrEnvironmentVariable("DATABASE_URL"))) {
			try {
				URI dbUri = new URI(EnvironmentUtility.getPropertyOrEnvironmentVariable("DATABASE_URL"));
				String username = dbUri.getUserInfo().split(":")[0];
				String password = dbUri.getUserInfo().split(":")[1];
				String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

				properties.put("hibernate.hbm2ddl.auto", "");
				properties.put("javax.persistence.jdbc.driver", Driver.class.getName());
				properties.put("javax.persistence.jdbc.url", dbUrl);
				properties.put("javax.persistence.jdbc.user", username);
				properties.put("javax.persistence.jdbc.password", password);
				properties.put("hibernate.dialect", PostgreSQL95Dialect.class.getName());
			} catch (URISyntaxException e) {
				e.printStackTrace();
				System.out.println("Database not found");
				System.exit(1);
			}
		}
		persistModule.properties(properties);
		injector = Guice.createInjector(persistModule);

		injector.getInstance(Database.class).init("9998", "9999", true);
	}

	public static void initServer() {
		port(getHerokuAssignedPort());
		CorsHeaders.init();
	}

	static int getHerokuAssignedPort() {
		ProcessBuilder processBuilder = new ProcessBuilder();
		if (processBuilder.environment().get(HEROKU_PORT) != null) {
			return Integer.parseInt(processBuilder.environment().get(HEROKU_PORT));
		}
		return 4567; // return default port if heroku-port isn't set (i.e. on localhost)
	}

	@SuppressWarnings("unused")
	private static class TranslatedMessage {
		private String messageKey;
		private List<String> parameters;
	}

}
