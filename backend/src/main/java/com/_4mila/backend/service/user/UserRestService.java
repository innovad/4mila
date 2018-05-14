package com._4mila.backend.service.user;

import static spark.Spark.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com._4mila.backend.JwtUtility;
import com._4mila.backend.service.AbstractRestService;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.persist.UnitOfWork;

import spark.Spark;

public class UserRestService extends AbstractRestService<UserDatabaseService> {

	private static final Logger logger = LoggerFactory.getLogger(UserRestService.class);

	@Inject
	Injector injector;

	@Inject
	UnitOfWork unitOfWork;

	@Inject
	public UserRestService(Injector injector) {
		super(injector, UserDatabaseService.class);
	}

	@Override
	public void init() {

		// Login
		post("services/login", (req, res) -> {
			CredentialView credentialView = fromJson(req.body(), CredentialView.class);
			String username = credentialView.username;
			String password = credentialView.password;
			LoginView result = new LoginView();
			if (username.equalsIgnoreCase("4") && password.equalsIgnoreCase("m")) {
				String jwtString = JwtUtility.createJsonWebToken(username, "en");
				res.header("Authorization", jwtString);
				result.jwt = jwtString;
				result.languageCode = "en";
			} else {
				logger.info("Login denied with user " + username);
				Spark.halt(401, "Wrong user/pw");
			}
			return result;
		}, getJsonTransformer());
	}

	private class CredentialView {
		private String username;
		private String password;
	}

	@SuppressWarnings("unused")
	private class LoginView {
		private String jwt;
		private String languageCode;
	}

}