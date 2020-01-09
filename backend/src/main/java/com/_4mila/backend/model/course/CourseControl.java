package com._4mila.backend.model.course;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com._4mila.backend.model.AbstractEntity;
import com._4mila.backend.model.control.Control;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "course_key", "control_key", "sortOrder" }) })
public class CourseControl extends AbstractEntity implements Comparable<CourseControl> {

	@ManyToOne
	private Course course;

	@ManyToOne
	private Control control;

	private long sortOrder;

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Control getControl() {
		return control;
	}

	public void setControl(Control control) {
		this.control = control;
	}

	public long getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(long sortOrder) {
		this.sortOrder = sortOrder;
	}

	@Override
	public int compareTo(CourseControl o) {
		int sortOrderComparison = Long.valueOf(this.sortOrder).compareTo(o.sortOrder);
		if (sortOrderComparison != 0) {
			return sortOrderComparison;
		}
		int nameComparison = this.getControl().compareTo(o.getControl());
		if (nameComparison != 0) {
			return nameComparison;
		}
		return this.getKey().compareTo(o.getKey());
	}

}
