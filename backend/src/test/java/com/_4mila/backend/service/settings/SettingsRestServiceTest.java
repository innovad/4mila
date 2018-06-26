package com._4mila.backend.service.settings;

import com._4mila.backend.model.settings.Settings;
import com._4mila.backend.service.AbstractCrudRestServiceTest;
import com._4mila.backend.service.runner.settings.SettingsRestService;

public class SettingsRestServiceTest extends AbstractCrudRestServiceTest<Settings, Long> {

	@Override
	protected Class<?> getService() {
		return SettingsRestService.class;
	}

	@Override
	protected Class<Settings> getEntityClass() {
		return Settings.class;
	}
	
}
