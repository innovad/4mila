package com._4mila.backend.server.json;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateConverter implements JsonSerializer<LocalDate>, JsonDeserializer<LocalDate> {
	private static final DateTimeFormatter FORMATTER_DATE_TIME = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
	private static final DateTimeFormatter FORMATTER_DATE = DateTimeFormatter.ISO_LOCAL_DATE;

	@Override
	public JsonElement serialize(LocalDate src, Type typeOfSrc, JsonSerializationContext context) {
		return new JsonPrimitive(FORMATTER_DATE.format(src));
	}

	@Override
	public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		return FORMATTER_DATE_TIME.parse(json.getAsString(), LocalDate::from);
	}
}