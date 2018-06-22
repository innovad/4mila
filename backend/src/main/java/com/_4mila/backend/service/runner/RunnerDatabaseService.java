package com._4mila.backend.service.runner;

import java.util.List;

import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import com._4mila.backend.model.runner.Runner;
import com._4mila.backend.model.runner.Runner_;
import com._4mila.backend.service.AbstractCrudDatabaseService;
import com._4mila.backend.service.PathListEntry;

public class RunnerDatabaseService extends AbstractCrudDatabaseService<Runner, Long> {

	@Override
	public Class<Runner> getEntityClass() {
		return Runner.class;
	}

	@Override
	public void createPathListEntry(Runner entity, PathListEntry<Long> entry) {
		entry.setKey(entity.getKey(), getKeyName());
		entry.setName(entity.getFamilyName() + " " + entity.getFirstName());
	}

	@Override
	protected void orderBy(Root<Runner> root, List<Order> orderList) {
		orderList.add(getCriteriaBuilder().asc(root.get(Runner_.familyName)));
		orderList.add(getCriteriaBuilder().asc(root.get(Runner_.firstName)));
	}

}