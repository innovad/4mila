package com._4mila.backend.service.entry;

import static spark.Spark.get;

import java.util.ArrayList;
import java.util.List;

import com._4mila.backend.model.entry.Entry;
import com._4mila.backend.model.race.Race;
import com._4mila.backend.service.AbstractCrudRestService;
import com._4mila.backend.service.clazz.EventClazzDatabaseService;
import com._4mila.backend.service.race.RaceDatabaseService;
import com._4mila.backend.service.runner.RunnerDatabaseService;
import com.google.common.primitives.Longs;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class EntryRestService extends AbstractCrudRestService<Entry, Long, EntryDatabaseService> {

	@Inject
	RaceDatabaseService raceDatabaseService;
	
	@Inject
	RunnerDatabaseService runnerDatabaseService;
	
	@Inject
	EventClazzDatabaseService eventClazzDatabaseService;
	
	@Inject
	public EntryRestService(Injector injector) {
		super(injector, EntryDatabaseService.class);
	}
	
	@Override
	protected void initGet() {
		super.initGet();

		// TODO should be a post or put service
		// currently always creates a new entry
		get("services/entry/:entryKey/runner/:runnerKey/eventClazz/:eventClazzKey", (req, res) -> {
			Long runnerKey = Longs.tryParse(req.params("runnerKey"));
			Long eventClazzKey = Longs.tryParse(req.params("eventClazzKey"));

			Race race = getCrudDatabaseService().createEntryWithRace(runnerKey, eventClazzKey);
			
			List<Race> results = new ArrayList<>();
			results.add(race);
			return raceDatabaseService.createPathList(results);
		}, getJsonTransformer());
	}


}
