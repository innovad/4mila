package com._4mila.backend.service.race;

import java.util.List;

import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import com._4mila.backend.model.race.Race;
import com._4mila.backend.service.AbstractCrudDatabaseService;
import com._4mila.backend.service.PathListEntry;

public class RaceDatabaseService extends AbstractCrudDatabaseService<Race, Long> {

	@Override
	public Class<Race> getEntityClass() {
		return Race.class;
	}

	@Override
	public void createPathListEntry(Race entity, PathListEntry<Long> entry) {
		entry.setKey(entity.getKey(), getKeyName());
		if (entity.getRunner() != null) {
			entry.setName(entity.getRunner().getName());
		}
		if (entity.getEventClazz() != null) {
			entry.getDetails().add(entity.getEventClazz().getClazz().getName());
		}
	}

	@Override
	protected void orderBy(Root<Race> root, List<Order> orderList) {
	}

}