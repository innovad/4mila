package com._4mila.backend.service.runner;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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
		entry.setName(entity.getName());
		if (entity.getDefaultEcard() != null) {
			entry.getDetails().add(entity.getDefaultEcard().getId());
		}
	}

	@Override
	protected void orderBy(Root<Runner> root, List<Order> orderList) {
		orderList.add(getCriteriaBuilder().asc(root.get(Runner_.familyName)));
		orderList.add(getCriteriaBuilder().asc(root.get(Runner_.firstName)));
	}

	public List<Runner> find(String search) {
		return list();
	}

	public class NameFilter extends AbstractCrudDatabaseService<Runner, Long>.AbstractListFilter {
		private String name;

		public NameFilter(String name) {
			super();
			this.name = name;
		}

		@Override
		public void appendFilter(CriteriaQuery<Runner> criteriaQuery, Root<Runner> root) {
			if (name != null) {
				name = name.toLowerCase();
				name = "%" + name + "%";
			}
			CriteriaBuilder cb = getCriteriaBuilder();
			addPredicate(criteriaQuery, cb.or(
					cb.like(cb.lower(root.get(Runner_.familyName)), name),
					cb.like(cb.lower(root.get(Runner_.firstName)), name)));
		}
	}

}