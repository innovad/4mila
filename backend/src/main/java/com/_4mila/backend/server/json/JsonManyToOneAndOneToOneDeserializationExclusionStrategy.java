package com._4mila.backend.server.json;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

/**
 * Exclude {@link ManyToOne} and {@link OneToOne} from Json Deserialization due to foreign keys
 *
 */
public class JsonManyToOneAndOneToOneDeserializationExclusionStrategy implements ExclusionStrategy {

	public boolean shouldSkipClass(Class<?> clazz) {
		return false;
	}

	public boolean shouldSkipField(FieldAttributes f) {
		return f.getAnnotation(ManyToOne.class) != null || f.getAnnotation(OneToOne.class) != null;
	}

}