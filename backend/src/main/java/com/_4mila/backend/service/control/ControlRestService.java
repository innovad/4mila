package com._4mila.backend.service.control;

import static spark.Spark.get;

import java.util.ArrayList;
import java.util.Collection;

import com._4mila.backend.model.control.Control;
import com._4mila.backend.service.AbstractCrudRestService;
import com._4mila.backend.service.PathListEntry;
import com._4mila.backend.service.event.EventDatabaseService;
import com.google.common.primitives.Longs;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class ControlRestService extends AbstractCrudRestService<Control, Long, ControlDatabaseService> {

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
		
		get("services/event/:eventKey/control/summary", (req, res) -> {
			Long eventNr = Longs.tryParse(req.params("eventKey"));
			Collection<PathListEntry<Long>> resultList = new ArrayList<>();
			PathListEntry<Long> entry = new PathListEntry<>();
			entry.setName("Controls"); // translation
			entry.setKey(eventNr, "eventKey");
			entry.getDetails().add("" + eventDatabaseService.read(eventNr).getControls().size());
			resultList.add(entry);
			return resultList;
		}, getJsonTransformer());
	}

}
