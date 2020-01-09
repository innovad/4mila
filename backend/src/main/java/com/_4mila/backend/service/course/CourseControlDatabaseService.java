package com._4mila.backend.service.course;

import java.util.List;

import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import com._4mila.backend.model.course.CourseControl;
import com._4mila.backend.model.course.CourseControl_;
import com._4mila.backend.service.AbstractCrudDatabaseService;
import com._4mila.backend.service.PathListEntry;
import com._4mila.backend.service.control.ControlDatabaseService;
import com.google.inject.Inject;

public class CourseControlDatabaseService extends AbstractCrudDatabaseService<CourseControl, Long> {

	@Inject
	ControlDatabaseService controlDatabaseService;
	
	@Override
	public Class<CourseControl> getEntityClass() {
		return CourseControl.class;
	}

	@Override
	public void createPathListEntry(CourseControl entity, PathListEntry<Long> entry) {
		entry.getDetails().add(String.valueOf(entity.getSortOrder()));
		if (entity.getControl() != null) {
			controlDatabaseService.createPathListEntry(entity.getControl(), entry);
		}
		entry.setKey(entity.getKey(), getKeyName());
	}

	@Override
	protected void orderBy(Root<CourseControl> root, List<Order> orderList) {
		orderList.add(getCriteriaBuilder().asc(root.get(CourseControl_.sortOrder)));
	}

}