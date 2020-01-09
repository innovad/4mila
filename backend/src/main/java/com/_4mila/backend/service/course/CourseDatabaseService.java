package com._4mila.backend.service.course;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import com._4mila.backend.model.control.ControlType;
import com._4mila.backend.model.course.Course;
import com._4mila.backend.model.course.CourseControl;
import com._4mila.backend.model.course.Course_;
import com._4mila.backend.service.AbstractCrudDatabaseService;
import com._4mila.backend.service.PathListEntry;
import com.google.inject.Inject;

public class CourseDatabaseService extends AbstractCrudDatabaseService<Course, Long> {

	@Inject
	CourseControlDatabaseService courseControlDatabaseService;

	@Override
	public Class<Course> getEntityClass() {
		return Course.class;
	}

	@Override
	public void createPathListEntry(Course entity, PathListEntry<Long> entry) {
		entry.setKey(entity.getKey(), getKeyName());
		entry.setName(entity.getName());

		int controlCount = entity.getCourseControls().stream().filter(courseControl -> {
			if (courseControl.getControl() != null) {
				return courseControl.getControl().getType().equals(ControlType.control);
			}
			return false;
		}).collect(Collectors.toSet()).size();

		if (controlCount == 1) {
			entry.getDetails().add(controlCount + " control");
		} else {
			entry.getDetails().add(controlCount + " controls");
		}
	}

	@Override
	protected void orderBy(Root<Course> root, List<Order> orderList) {
		orderList.add(getCriteriaBuilder().asc(root.get(Course_.name)));
	}

	public void deleteCourseControls(Course entity) {
		for (CourseControl courseControl : entity.getCourseControls()) {
			courseControlDatabaseService.delete(courseControl);
		}
	}

	@Override
	protected void beforeDelete(Course entity) {
		super.beforeDelete(entity);
		deleteCourseControls(entity);
	}

	public class EventFilter extends AbstractCrudDatabaseService<Course, Long>.AbstractListFilter {

		private Long eventKey;

		public EventFilter(Long eventKey) {
			super();
			this.eventKey = eventKey;
		}

		@Override
		public void appendFilter(CriteriaQuery<Course> criteriaQuery, Root<Course> root) {
			CriteriaBuilder cb = getCriteriaBuilder();
			addPredicate(criteriaQuery, cb.equal(root.get(Course_.event), eventKey));
		}
	}

}