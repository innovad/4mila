package com._4mila.backend.service;

import com._4mila.backend.server.json.JsonHelper;
import com._4mila.backend.server.json.JsonTransformer;
import com.google.inject.Inject;
import com.google.inject.Injector;

public abstract class AbstractRestService<T extends AbstractDatabaseService> {

	@Inject
	JsonHelper jsonHelper;
	
	private T databaseService;

	public AbstractRestService(Injector injector, Class<T> databaseServiceClass) {
		super();
		this.databaseService = injector.getInstance(databaseServiceClass);
	}

	public abstract void init();

	protected <C> C fromJson(String json, Class<C> classOfC) {
		return jsonHelper.fromJson(json, classOfC);
	}

	protected JsonTransformer getJsonTransformer() {
		return jsonHelper.getJsonTransformer();
	}

	protected T getDatabaseService() {
		return databaseService;
	}
	
}
