package com._4mila.backend.service.race;

import java.util.List;

import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import com._4mila.backend.model.race.RaceControl;
import com._4mila.backend.service.AbstractCrudDatabaseService;
import com._4mila.backend.service.PathListEntry;

public class RaceControlDatabaseService extends AbstractCrudDatabaseService<RaceControl, Long> {

	@Override
	public Class<RaceControl> getEntityClass() {
		return RaceControl.class;
	}

	@Override
	public void createPathListEntry(RaceControl entity, PathListEntry<Long> entry) {
		entry.setKey(entity.getKey(), getKeyName());
		if (entity.getCourseControl() != null && entity.getCourseControl().getControl() != null) {
			entry.setName(entity.getCourseControl().getControl().getId());
		}
	}

	@Override
	protected void orderBy(Root<RaceControl> root, List<Order> orderList) {
	}

}