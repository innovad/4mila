package com._4mila.backend.service.runner.csv;

import java.util.List;

import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import com._4mila.backend.model.runner.csv.RunnerImport;
import com._4mila.backend.model.runner.csv.RunnerImport_;
import com._4mila.backend.service.AbstractCrudDatabaseService;
import com._4mila.backend.service.PathListEntry;

public class RunnerImportDatabaseService extends AbstractCrudDatabaseService<RunnerImport, Long> {

	@Override
	public Class<RunnerImport> getEntityClass() {
		return RunnerImport.class;
	}

	@Override
	public void createPathListEntry(RunnerImport entity, PathListEntry<Long> entry) {
		entry.setKey(entity.getKey(), getKeyName());
		entry.setName(entity.getFamilyName());
	}

	@Override
	protected void orderBy(Root<RunnerImport> root, List<Order> orderList) {
		orderList.add(getCriteriaBuilder().asc(root.get(RunnerImport_.familyName)));
		orderList.add(getCriteriaBuilder().asc(root.get(RunnerImport_.firstName)));
	}

}