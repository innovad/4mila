package com._4mila.backend.service.event;

import java.util.List;

import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import com._4mila.backend.model.event.Event;
import com._4mila.backend.model.event.Event_;
import com._4mila.backend.service.AbstractCrudDatabaseService;
import com._4mila.backend.service.PathListEntry;

public class EventDatabaseService extends AbstractCrudDatabaseService<Event, Long> {

	@Override
	public Class<Event> getEntityClass() {
		return Event.class;
	}

	@Override
	public void createPathListEntry(Event entity, PathListEntry<Long> entry) {
		entry.setKey(entity.getKey(), getKeyName());
		entry.setName(entity.getName());
		entry.getDetails().add(entity.getCity());
	}

	@Override
	protected void orderBy(Root<Event> root, List<Order> orderList) {
		orderList.add(getCriteriaBuilder().asc(root.get(Event_.name)));
	}

}