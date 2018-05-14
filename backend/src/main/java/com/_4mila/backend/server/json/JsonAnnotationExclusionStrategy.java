package com._4mila.backend.server.json;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class JsonAnnotationExclusionStrategy implements ExclusionStrategy {

    @Override
    public boolean shouldSkipField(FieldAttributes f) {
        return f.getAnnotation(ExcludeFromJson.class) != null;
    }

    @Override
    public boolean shouldSkipClass(Class<?> clazz) {
        return false;
    }
}