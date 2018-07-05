package com._4mila.backend.service.ecard;

import java.util.List;

import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import com._4mila.backend.model.ecard.Ecard;
import com._4mila.backend.model.ecard.Ecard_;
import com._4mila.backend.service.AbstractCrudDatabaseService;
import com._4mila.backend.service.PathListEntry;

public class EcardDatabaseService extends AbstractCrudDatabaseService<Ecard, Long> {

	@Override
	public Class<Ecard> getEntityClass() {
		return Ecard.class;
	}

	@Override
	public void createPathListEntry(Ecard entity, PathListEntry<Long> entry) {
		entry.setKey(entity.getKey(), getKeyName());
		entry.setName(entity.getId());
	}

	@Override
	protected void orderBy(Root<Ecard> root, List<Order> orderList) {
		orderList.add(getCriteriaBuilder().asc(root.get(Ecard_.id)));
	}

}