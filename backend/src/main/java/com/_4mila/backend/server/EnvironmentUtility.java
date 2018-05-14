package com._4mila.backend.server;

import com.google.common.base.Strings;

public class EnvironmentUtility {

	private EnvironmentUtility() {
	}
	
	public static String getPropertyOrEnvironmentVariable(String property) {
		String value = System.getenv(property);
		if (Strings.isNullOrEmpty(value)) {
			value = System.getProperty(property);
		}
		return Strings.nullToEmpty(value);
	}
	
}
