package com._4mila.backend.server.json;

import javax.persistence.OneToMany;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

/**
 * Exclude {@link OneToMany} from Json Serialization due to JPA lazy loading
 *
 */
public class JsonOneToManyExclusionStrategy implements ExclusionStrategy {

	public boolean shouldSkipClass(Class<?> clazz) {
		return false;
	}

	public boolean shouldSkipField(FieldAttributes f) {
		return f.getAnnotation(OneToMany.class) != null;
	}

}