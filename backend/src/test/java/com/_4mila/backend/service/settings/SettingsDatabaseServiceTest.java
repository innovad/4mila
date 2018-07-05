package com._4mila.backend.service.settings;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com._4mila.backend.model.event.Event;
import com._4mila.backend.model.settings.Settings;
import com._4mila.backend.service.AbstractCrudDatabaseServiceTest;
import com._4mila.backend.service.event.EventDatabaseService;

public class SettingsDatabaseServiceTest extends AbstractCrudDatabaseServiceTest<Settings, Long> {

	@Override
	protected Class<?> getService() {
		return SettingsDatabaseService.class;
	}

	@Override
	protected Class<Settings> getEntity() {
		return Settings.class;
	}
	
	@Test
	public void testSettingsNotNull() throws Exception {
		assertNotNull(getInjector().getInstance(SettingsDatabaseService.class).getSettings());
	}
	
	@Test
	public void testEventSettings() throws Exception {
		SettingsDatabaseService settingsSvc = getInjector().getInstance(SettingsDatabaseService.class);
		EventDatabaseService eventSvc = getInjector().getInstance(EventDatabaseService.class);
		
		Event e1 = new Event();
		eventSvc.create(e1);
		
		Settings settings = settingsSvc.getSettings();
		settings.setDefaultEvent(e1);
		settingsSvc.update(settings);
		
		assertEquals(settingsSvc.getSettings().getDefaultEvent(), e1);
		settings = settingsSvc.getSettings();
		settings.setDefaultEvent(null);
		settingsSvc.update(settings);
		
		settingsSvc.delete(settings);
		eventSvc.delete(e1);
	}
	

}