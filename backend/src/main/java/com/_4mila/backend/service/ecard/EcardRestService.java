package com._4mila.backend.service.ecard;

import static spark.Spark.get;

import java.util.List;

import com._4mila.backend.model.ecard.Ecard;
import com._4mila.backend.service.AbstractCrudRestService;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class EcardRestService extends AbstractCrudRestService<Ecard, Long, EcardDatabaseService> {

	@Inject
	public EcardRestService(Injector injector) {
		super(injector, EcardDatabaseService.class);
	}

	@Override
	protected void initList() {
		super.initList();

		get("services/ecard/withoutRunner", (req, res) -> {
			List<Ecard> list = getCrudDatabaseService().list();
			list.removeIf(e -> !e.getRunners().isEmpty());
			return getDatabaseService().createPathList(list);
		}, getJsonTransformer());
	}

}
