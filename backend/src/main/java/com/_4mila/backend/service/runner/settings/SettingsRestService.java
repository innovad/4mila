package com._4mila.backend.service.runner.settings;

import com._4mila.backend.model.settings.Settings;
import com._4mila.backend.service.AbstractCrudRestService;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class SettingsRestService extends AbstractCrudRestService<Settings, Long> {

	@Inject
	public SettingsRestService(Injector injector) {
		super(injector, SettingsDatabaseService.class);
	}

}
