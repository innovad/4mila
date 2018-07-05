package com._4mila.backend.service.clazz;

import static spark.Spark.get;

import java.util.ArrayList;
import java.util.Collection;

import com._4mila.backend.model.clazz.EventClazz;
import com._4mila.backend.service.AbstractCrudRestService;
import com._4mila.backend.service.PathListEntry;
import com._4mila.backend.service.event.EventDatabaseService;
import com._4mila.backend.service.settings.SettingsDatabaseService;
import com.google.common.primitives.Longs;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class EventClazzRestService extends AbstractCrudRestService<EventClazz, Long> {

	@Inject
	EventDatabaseService eventDatabaseService;
	
	@Inject
	SettingsDatabaseService settingsDatabaseService;
	
	@Inject
	public EventClazzRestService(Injector injector) {
		super(injector, EventClazzDatabaseService.class);
	}
	
	@Override
	protected void initList() {
		super.initList();

		get("services/event/:eventKey/eventClazz", (req, res) -> {
			Long eventNr = Longs.tryParse(req.params("eventKey"));
			if (eventNr == null) {
				eventNr = settingsDatabaseService.getSettings().getDefaultEvent().getKey();
			}
			return getDatabaseService().createPathList(eventDatabaseService.read(eventNr).getEventClasses());
		}, getJsonTransformer());
		
		get("services/event/:eventKey/eventClazz/summary", (req, res) -> {
			Long eventNr = Longs.tryParse(req.params("eventKey"));
			Collection<PathListEntry<Long>> resultList = new ArrayList<>();
			PathListEntry<Long> entry = new PathListEntry<>();
			entry.setName("Classes"); // translation
			entry.setKey(eventNr, "eventKey");
			entry.getDetails().add("" + eventDatabaseService.read(eventNr).getEventClasses().size());
			resultList.add(entry);
			return resultList;
		}, getJsonTransformer());
	}

}
