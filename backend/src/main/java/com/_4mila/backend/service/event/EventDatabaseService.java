package com._4mila.backend.service.event;

import java.util.List;

import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import com._4mila.backend.model.event.Event;
import com._4mila.backend.model.event.Event_;
import com._4mila.backend.service.AbstractCrudDatabaseService;
import com._4mila.backend.service.PathListEntry;
import com._4mila.backend.service.settings.SettingsDatabaseService;
import com.google.inject.Inject;

public class EventDatabaseService extends AbstractCrudDatabaseService<Event, Long> {

	@Inject
	SettingsDatabaseService settingsDatabaseService;
	
	@Override
	public Class<Event> getEntityClass() {
		return Event.class;
	}

	@Override
	public void createPathListEntry(Event entity, PathListEntry<Long> entry) {
		entry.setKey(entity.getKey(), getKeyName());
		entry.setName(entity.getName());
		if (!entity.equals(settingsDatabaseService.getSettings().getDefaultEvent())) {
			entry.setColor("silver");
		} else {
			entry.getDetails().add("Current event");
		}
	}

	@Override
	protected void orderBy(Root<Event> root, List<Order> orderList) {
		orderList.add(getCriteriaBuilder().asc(root.get(Event_.name)));
	}

}