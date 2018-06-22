package com._4mila.backend.service.course;

import java.util.List;

import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import com._4mila.backend.model.course.Course;
import com._4mila.backend.model.course.Course_;
import com._4mila.backend.service.AbstractCrudDatabaseService;
import com._4mila.backend.service.PathListEntry;

public class CourseDatabaseService extends AbstractCrudDatabaseService<Course, Long> {

	@Override
	public Class<Course> getEntityClass() {
		return Course.class;
	}

	@Override
	public void createPathListEntry(Course entity, PathListEntry<Long> entry) {
		entry.setKey(entity.getKey(), getKeyName());
		entry.setName(entity.getName());
		if (entity.getCourseControls().size() == 1) {
			entry.getDetails().add(entity.getCourseControls().size() + " control");
		} else {
			entry.getDetails().add(entity.getCourseControls().size() + " controls");
		}
	}

	@Override
	protected void orderBy(Root<Course> root, List<Order> orderList) {
		orderList.add(getCriteriaBuilder().asc(root.get(Course_.name)));
	}

}