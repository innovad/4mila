package com._4mila.backend.service;

import java.util.ArrayList;
import java.util.Collection;

public final class RestUtility {

	private RestUtility() {
	}
		
	@FunctionalInterface
	public interface ButtonCustomizer<ENTITY> {
	  public void apply(ENTITY entity, PathListEntry<Long> button, Collection<ENTITY> collection);
	}
	
	public static <ENTITY> Collection<PathListEntry<Long>> createButtonList(Collection<ENTITY> collection, ButtonCustomizer<ENTITY> customizer) {
		Collection<PathListEntry<Long>> result = new ArrayList<>();
		for (ENTITY entity : collection) {
			PathListEntry<Long> entry = new PathListEntry<>();
			customizer.apply(entity, entry, collection);
			result.add(entry);
		}
		return result;
	}
	
}
