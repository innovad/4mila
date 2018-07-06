package com._4mila.backend.service.race;

import static spark.Spark.get;

import com._4mila.backend.model.race.RaceControl;
import com._4mila.backend.service.AbstractCrudRestService;
import com.google.common.primitives.Longs;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class RaceControlRestService extends AbstractCrudRestService<RaceControl, Long, RaceControlDatabaseService> {

	@Inject
	RaceDatabaseService raceDatabaseService;

	@Inject
	public RaceControlRestService(Injector injector) {
		super(injector, RaceControlDatabaseService.class);
	}

	@Override
	protected void initGet() {
		super.initGet();

		get("services/race/:raceKey/raceControl", (req, res) -> {
			Long raceKey = Longs.tryParse(req.params("raceKey"));
			return getDatabaseService().createPathList(raceDatabaseService.read(raceKey).getRaceControls());
		}, getJsonTransformer());
	}

}
