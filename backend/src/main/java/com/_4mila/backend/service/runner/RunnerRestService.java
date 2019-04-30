package com._4mila.backend.service.runner;

import static spark.Spark.get;

import java.util.Collections;

import com._4mila.backend.model.runner.Runner;
import com._4mila.backend.service.AbstractCrudRestService;
import com.google.common.base.Strings;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class RunnerRestService extends AbstractCrudRestService<Runner, Long, RunnerDatabaseService> {

	@Inject
	public RunnerRestService(Injector injector) {
		super(injector, RunnerDatabaseService.class);
	}

	@Override
	protected void initList() {
		super.initList();

		get("services/search/runner", (req, res) -> {
			String search = req.queryParams("search");
			// TODO use lucene for search
			if (Strings.isNullOrEmpty(search)) {
				return Collections.emptyList();
			} else {
				return getDatabaseService().createPathList(getCrudDatabaseService().list(getCrudDatabaseService().new NameFilter(search)));
			}
		}, getJsonTransformer());
	}

}
