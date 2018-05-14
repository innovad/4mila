package com._4mila.backend;

import java.security.Key;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.impl.crypto.MacProvider;
import spark.Request;

public final class JwtUtility {
	private static final String LANGUAGE_CODE = "languageCode";
	private static final Logger logger = LoggerFactory.getLogger(JwtUtility.class);
	private static final Key key = MacProvider.generateKey();
	private static final int expirationDuration = 1000 * 1800;

	public static String createJsonWebToken(String userId, String languageCode) {
		Claims claims = Jwts.claims().setSubject(userId);
		claims.put(LANGUAGE_CODE, languageCode);
		claims.setExpiration(new Date(System.currentTimeMillis() + expirationDuration));
		claims.setIssuedAt(new Date());
		String compactJws = Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, key).compact();
		return compactJws;
	}

	public static Jws<Claims> getJsonWebToken(Request request) {
		Jws<Claims> jwt = null;
		String jwtString = request.headers("Authorization");
		if (jwtString == null && request.queryParams("token") != null) {
			jwtString = request.queryParams("token");
		}
		if (jwtString != null) {
			try {
				jwt = Jwts.parser().setSigningKey(key).parseClaimsJws(jwtString);
				logger.debug("jwt subject: " + jwt.getBody().getSubject() + ", expiry: " + jwt.getBody().getExpiration());
			} catch (SignatureException e) {
				logger.info("JWT invalid signature - discarded");
			} catch (ExpiredJwtException e) {
				logger.info("Jwt Expired: " + e.getLocalizedMessage());
			} catch (Exception e) {
				logger.info("login", e);
			}
		}
		return jwt;
	}
	
	public static String getLanguage(Jws<Claims> jwt) {
		return jwt.getBody().get(LANGUAGE_CODE).toString();
	}

}
