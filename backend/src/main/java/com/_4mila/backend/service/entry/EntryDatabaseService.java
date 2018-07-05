package com._4mila.backend.service.entry;

import java.util.List;

import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import com._4mila.backend.model.entry.Entry;
import com._4mila.backend.model.entry.Entry_;
import com._4mila.backend.service.AbstractCrudDatabaseService;
import com._4mila.backend.service.PathListEntry;

public class EntryDatabaseService extends AbstractCrudDatabaseService<Entry, Long> {

	@Override
	public Class<Entry> getEntityClass() {
		return Entry.class;
	}

	@Override
	public void createPathListEntry(Entry entity, PathListEntry<Long> entry) {
		entry.setKey(entity.getKey(), getKeyName());
		entry.setName("" + entity.getRaces().size());
	}

	@Override
	protected void orderBy(Root<Entry> root, List<Order> orderList) {
		orderList.add(getCriteriaBuilder().asc(root.get(Entry_.key)));
	}

}