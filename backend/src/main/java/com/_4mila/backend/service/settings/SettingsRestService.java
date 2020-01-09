package com._4mila.backend.service.settings;

import static spark.Spark.get;

import com._4mila.backend.model.event.Event;
import com._4mila.backend.model.settings.Settings;
import com._4mila.backend.service.AbstractCrudRestService;
import com._4mila.backend.service.event.EventDatabaseService;
import com._4mila.backend.service.exception.PermissionView;
import com.google.common.primitives.Longs;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class SettingsRestService extends AbstractCrudRestService<Settings, Long, SettingsDatabaseService> {

	@Inject
	EventDatabaseService eventDatabaseService;

	@Inject
	public SettingsRestService(Injector injector) {
		super(injector, SettingsDatabaseService.class);
	}

	@Override
	protected void initGet() {
		super.initGet();

		get("services/settings/current/event/:eventKey", (req, res) -> {
			Long eventKey = Longs.tryParse(req.params("eventKey"));
			Event event = eventDatabaseService.read(eventKey);
			Settings settings = getCrudDatabaseService().getSettings();
			return new PermissionView(!event.equals(settings.getDefaultEvent()));
		}, getJsonTransformer());
		
		get("services/settings/event/:eventKey", (req, res) -> {
			Long eventKey = Longs.tryParse(req.params("eventKey"));
			Event event = eventDatabaseService.read(eventKey);
			Settings settings = getCrudDatabaseService().getSettings();
			settings.setDefaultEvent(event);
			return getCrudDatabaseService().update(settings);
		}, getJsonTransformer());
	}

}
