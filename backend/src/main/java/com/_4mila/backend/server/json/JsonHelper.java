package com._4mila.backend.server.json;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com._4mila.backend.service.AbstractCrudDatabaseService;
import com._4mila.backend.service.AbstractDatabaseService;
import com._4mila.backend.service.PathListEntry.Key;
import com._4mila.backend.service.exception.BackendValidationException;
import com.google.common.primitives.Longs;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;

@Singleton
public class JsonHelper {

	private final Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateConverter()).registerTypeAdapter(Key.class, new PathListEntryKeyAdapter()).enableComplexMapKeySerialization().setExclusionStrategies(new JsonAnnotationExclusionStrategy(), new JsonOneToManyExclusionStrategy()).addDeserializationExclusionStrategy(new JsonManyToOneAndOneToOneDeserializationExclusionStrategy()).create();
	private final JsonTransformer jsonTransformer = new JsonTransformer(gson);
	private static final Logger logger = LoggerFactory.getLogger(JsonHelper.class);
	
	@Inject
	Injector injector;

	public <C> C fromJson(String json, Class<C> classOfC) {
		Map<Field, Object> foreignObjects = new HashMap<>();
		for (Field field : ReflectionUtility.getAllFields(classOfC)) {
			if (field.getAnnotation(ManyToOne.class) != null || field.getAnnotation(OneToOne.class) != null) {
				String foreignKeyServiceClass = field.getType().getName().replace(".model.", ".service.") + "DatabaseService";
				try {
					// find and create foreign service
					Class<?> foreignKeyService = Thread.currentThread().getContextClassLoader().loadClass(foreignKeyServiceClass);
					AbstractDatabaseService foreignKeyServiceInstance = (AbstractDatabaseService) injector.getInstance(foreignKeyService);
					Method getMethod = foreignKeyServiceInstance.getClass().getMethod("read", Object.class);

					// get type of key field
					List<Field> foreignKeyClassFields = ReflectionUtility.getAllFields(((AbstractCrudDatabaseService<?, ?>) foreignKeyServiceInstance).getEntityClass());
					Field foreignKeyClassField = null;
					for (Field currentField : foreignKeyClassFields) {
						if (currentField.getName().equals("key")) {
							foreignKeyClassField = currentField;
							break;
						}
					}
					if (foreignKeyClassField == null) {
						throw new RuntimeException("no key field found on type " + field.getName());
					}

					// parse foreign key value
					JsonParser parser = new JsonParser();
					JsonObject obj = parser.parse(json).getAsJsonObject();
					JsonElement jsonElement = obj.get(field.getName());
					Object fieldValue = null;
					if (jsonElement != null && !(jsonElement instanceof JsonNull)) {
						if (String.class.isAssignableFrom(foreignKeyClassField.getType())) {
							fieldValue = jsonElement.getAsString();
						} else if (Enum.class.isAssignableFrom(foreignKeyClassField.getType())) {
							fieldValue = parseEnum(foreignKeyClassField, jsonElement.getAsString());
						} else if (Number.class.isAssignableFrom(foreignKeyClassField.getType())) {
							fieldValue = Longs.tryParse(jsonElement.getAsString());
						}
					}

					// find foreign object
					Object foreignObject = null;
					if (fieldValue != null) {
						foreignObject = getMethod.invoke(foreignKeyServiceInstance, fieldValue);
					}
					foreignObjects.put(field, foreignObject);
				} catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException e) {
					throw new RuntimeException("Failed creating foreign key object for " + field.getName(), e);
				}
			}
		}
		C object = null;
		try {
			object = gson.fromJson(json, classOfC);
		} catch (JsonSyntaxException e) {
			BackendValidationException backendValidationException = new BackendValidationException("BackendFormatError");
			backendValidationException.getParameters().add(e.getMessage());
			logger.error("BackendFormatError", e);
			throw backendValidationException;
		}
		for (Field field : foreignObjects.keySet()) {
			Object foreignObject = foreignObjects.get(field);
			try {
				// set foreign key object
				String methodNameLowerCase = "set" + field.getName().toLowerCase();
				String setterMethod = null;
				for (Method method : object.getClass().getMethods()) {
					if (method.getName().equalsIgnoreCase(methodNameLowerCase)) {
						setterMethod = method.getName();
					}
				}
				Method method = object.getClass().getMethod(setterMethod, field.getType());
				method.invoke(object, foreignObject);
			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				throw new RuntimeException("Failed setting foreign key object for " + field.getName(), e);
			}
		}
		return object;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Object parseEnum(Field enumField, String value) {
		Object fieldValue;
		Class<? extends Enum> enumType = (Class<? extends Enum>) enumField.getType();
		fieldValue = Enum.valueOf(enumType, value);
		return fieldValue;
	}

	public Gson getGson() {
		return gson;
	}

	public JsonTransformer getJsonTransformer() {
		return jsonTransformer;
	}

}
