package com._4mila.backend.service.user;

import static spark.Spark.after;
import static spark.Spark.get;
import static spark.Spark.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com._4mila.backend.JwtUtility;
import com._4mila.backend.model.user.User;
import com._4mila.backend.model.user.permission.PermissionFunctionEnum;
import com._4mila.backend.service.AbstractCrudRestService;
import com._4mila.backend.service.PermissionCheckView;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.persist.UnitOfWork;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import spark.Spark;

public class UserRestService extends AbstractCrudRestService<User, Long, UserDatabaseService> {

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
	protected void initGet() {
		super.initGet();

		// Login
		get("services/permission/isAdmin", (req, res) -> {
			return new PermissionCheckView(getCrudDatabaseService().checkPermissionFunction(getCrudDatabaseService().getCurrentUser(req), PermissionFunctionEnum.readAdministration.toString()));
		}, getJsonTransformer());

	}

	@Override
	public void initPost() {
		super.initPost();

		// Login
		post("services/login", (req, res) -> {
			CredentialView credentialView = fromJson(req.body(), CredentialView.class);
			String username = credentialView.username;
			String password = credentialView.password;
			LoginView result = new LoginView();
			if (getCrudDatabaseService().validateCredentials(username, password)) {
				String jwtString = JwtUtility.createJsonWebToken(username, "en");
				res.header("Authorization", jwtString);
				result.jwt = jwtString;
				result.languageCode = "de";
			} else {
				logger.info("Login denied with user " + username);
				Spark.halt(401, "Wrong user/pw");
			}
			return result;
		}, getJsonTransformer());

		after("/services/*", (req, res) -> {
			// if a response contains an jwt, then renew expiry date
			if (!res.raw().containsHeader("Authorization")) {
				Jws<Claims> jwt = JwtUtility.getJsonWebToken(req);
				if (jwt != null) {
					String jwtString = JwtUtility.createJsonWebToken(jwt.getBody().getSubject(), JwtUtility.getLanguage(jwt));
					res.header("Authorization", jwtString);
				}
			}
		});
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