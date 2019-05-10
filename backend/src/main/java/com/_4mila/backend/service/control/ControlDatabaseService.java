package com._4mila.backend.service.control;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import com._4mila.backend.model.control.Control;
import com._4mila.backend.model.control.ControlType;
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
		if (entity.getType() != null && ControlType.control.equals(entity.getType())) {
			entry.getDetails().add("Control");
		} else if (entity.getType() != null && ControlType.start.equals(entity.getType())) {
			entry.getDetails().add("Start");
			entry.setIcon("fa-play-circle");
			entry.setColor("sun-flower");
		} else if (entity.getType() != null && ControlType.finish.equals(entity.getType())) {
			entry.getDetails().add("Finish");
			entry.setIcon("fa-dot-circle");
			entry.setColor("sun-flower");
		}
	}

	@Override
	protected void orderBy(Root<Control> root, List<Order> orderList) {
		orderList.add(getCriteriaBuilder().asc(root.get(Control_.id)));
	}

	@Override
	protected Control prepare() {
		Control defaultValue = new Control();
		defaultValue.setType(ControlType.control);
		return defaultValue;
	}

	public class EventFilter extends AbstractCrudDatabaseService<Control, Long>.AbstractListFilter {

		private Long eventKey;

		public EventFilter(Long eventKey) {
			super();
			this.eventKey = eventKey;
		}

		@Override
		public void appendFilter(CriteriaQuery<Control> criteriaQuery, Root<Control> root) {
			CriteriaBuilder cb = getCriteriaBuilder();
			addPredicate(criteriaQuery, cb.equal(root.get(Control_.event), eventKey));
		}
	}

}