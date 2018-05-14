package com._4mila.backend.service.control;

import java.util.List;

import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import com._4mila.backend.model.control.Control;
import com._4mila.backend.model.control.Control_;
import com._4mila.backend.service.AbstractCrudDatabaseService;
import com._4mila.backend.service.PathListEntry;

public class ControlDatabaseService extends AbstractCrudDatabaseService<Control, Long> {

	@Override
	public Class<Control> getEntityClass() {
		return Control.class;
	}

	@Override
	public void createPathListEntry(Control entity, PathListEntry<Long> entry) {
		entry.setKey(entity.getKey(), getKeyName());
		entry.setName(entity.getId());
	}

	@Override
	protected void orderBy(Root<Control> root, List<Order> orderList) {
		orderList.add(getCriteriaBuilder().asc(root.get(Control_.id)));
	}

}