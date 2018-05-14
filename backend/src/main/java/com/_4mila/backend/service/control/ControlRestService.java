package com._4mila.backend.service.control;

import static spark.Spark.get;

import com._4mila.backend.model.control.Control;
import com._4mila.backend.service.AbstractCrudRestService;
import com._4mila.backend.service.event.EventDatabaseService;
import com.google.common.primitives.Longs;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class ControlRestService extends AbstractCrudRestService<Control, Long> {

	@Inject
	EventDatabaseService eventDatabaseService;

	@Inject
	public ControlRestService(Injector injector) {
		super(injector, ControlDatabaseService.class);
	}

	@Override
	protected void initList() {
		super.initList();

		get("services/event/:eventKey/control", (req, res) -> {
			Long eventNr = Longs.tryParse(req.params("eventKey"));
			return getDatabaseService().createPathList(eventDatabaseService.read(eventNr).getControls());
		}, getJsonTransformer());
	}

}
