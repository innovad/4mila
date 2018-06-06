package com._4mila.backend.service.clazz;

import java.util.List;

import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import com._4mila.backend.model.clazz.Clazz;
import com._4mila.backend.model.clazz.Clazz_;
import com._4mila.backend.service.AbstractCrudDatabaseService;
import com._4mila.backend.service.PathListEntry;

public class ClazzDatabaseService extends AbstractCrudDatabaseService<Clazz, Long> {

	@Override
	public Class<Clazz> getEntityClass() {
		return Clazz.class;
	}

	@Override
	public void createPathListEntry(Clazz entity, PathListEntry<Long> entry) {
		entry.setKey(entity.getKey(), getKeyName());
		entry.setName(entity.getName());
		int count = entity.getEventClasses().size();
		if (count == 1) {
			entry.getDetails().add(count + " Event");
		} else {
			entry.getDetails().add(count + " Events");
		}
	}

	@Override
	protected void orderBy(Root<Clazz> root, List<Order> orderList) {
		orderList.add(getCriteriaBuilder().asc(root.get(Clazz_.name)));
	}

}