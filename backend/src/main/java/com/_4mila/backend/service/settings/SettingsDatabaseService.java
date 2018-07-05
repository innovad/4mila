package com._4mila.backend.service.settings;

import java.util.List;

import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import com._4mila.backend.model.settings.Settings;
import com._4mila.backend.service.AbstractCrudDatabaseService;
import com._4mila.backend.service.PathListEntry;
import com._4mila.backend.service.exception.BackendValidationException;

public class SettingsDatabaseService extends AbstractCrudDatabaseService<Settings, Long> {

	@Override
	public Class<Settings> getEntityClass() {
		return Settings.class;
	}

	@Override
	public void createPathListEntry(Settings entity, PathListEntry<Long> entry) {
		entry.setKey(entity.getKey(), getKeyName());
	}

	@Override
	protected void orderBy(Root<Settings> root, List<Order> orderList) {
	}
	
	@Override
	protected void afterCreate(Settings entity) {
		super.afterCreate(entity);
		if (list().size() > 1) {
			throw new BackendValidationException("MultipleSettingsNotAllowed");
		}
	}
	
	public Settings getSettings() {
		if (list().size() == 1) {
			return list().get(0);
		}
		return new Settings();
	}
	
}