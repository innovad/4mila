package com._4mila.backend.service.clazz;

import java.util.List;

import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import com._4mila.backend.model.clazz.EventClazz;
import com._4mila.backend.model.clazz.EventClazz_;
import com._4mila.backend.service.AbstractCrudDatabaseService;
import com._4mila.backend.service.PathListEntry;

public class EventClazzDatabaseService extends AbstractCrudDatabaseService<EventClazz, Long> {

	@Override
	public Class<EventClazz> getEntityClass() {
		return EventClazz.class;
	}

	@Override
	public void createPathListEntry(EventClazz entity, PathListEntry<Long> entry) {
		entry.setKey(entity.getKey(), getKeyName());
		if (entity.getClazz() != null) {
			entry.setName(entity.getClazz().getName());
		}
	}

	@Override
	protected void orderBy(Root<EventClazz> root, List<Order> orderList) {
		orderList.add(getCriteriaBuilder().asc(root.get(EventClazz_.clazz)));
	}

}