package com._4mila.backend.server;

import static spark.Spark.before;
import static spark.Spark.options;

public class CorsHeaders {

	public final static void init() {
		options("/*", (request, response) -> {

			String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
			if (accessControlRequestHeaders != null) {
				response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
			}

			String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
			if (accessControlRequestMethod != null) {
				response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
			}

			return "{ \"status\": \"ok\"}";
		});

		before((request, response) -> {
			response.header("Access-Control-Allow-Origin", "*");
			response.header("Access-Control-Request-Method", "*");
			response.header("Access-Control-Allow-Headers", request.headers("Access-Control-Request-Headers"));
			response.header("Access-Control-Expose-Headers", "Authorization");
			response.type("application/json");
		});
	}
}
