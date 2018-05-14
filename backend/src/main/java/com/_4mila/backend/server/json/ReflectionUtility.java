package com._4mila.backend.server.json;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ReflectionUtility {

	private static List<Field> getAllFields(List<Field> fields, Class<?> type) {
		fields.addAll(Arrays.asList(type.getDeclaredFields()));
		if (type.getSuperclass() != null) {
			fields = getAllFields(fields, type.getSuperclass());
		}
		return fields;
	}
	
	public static List<Field> getAllFields(Class<?> type) {
		return getAllFields(new ArrayList<>(), type);
	}
	
	
}
