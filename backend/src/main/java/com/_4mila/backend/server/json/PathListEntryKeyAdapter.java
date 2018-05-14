package com._4mila.backend.server.json;


import java.lang.reflect.Type;

import com._4mila.backend.service.PathListEntry.Key;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

@SuppressWarnings("rawtypes")
public class PathListEntryKeyAdapter implements JsonSerializer<Key> {

	@Override
	public JsonElement serialize(Key key, Type typeOfSrc, JsonSerializationContext context) {
		JsonObject result = new JsonObject();
		result.addProperty("name", key.getName());
		result.addProperty("key", String.valueOf(key.getKey()));
		return result;
	}

}