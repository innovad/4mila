package com._4mila.backend.model.course.iof2;

import javax.persistence.Entity;

import com._4mila.backend.model.AbstractEntity;

@Entity
public class CourseImport extends AbstractEntity implements Comparable<CourseImport> {

	@Override
	public int compareTo(CourseImport o) {
		return this.getKey().compareTo(o.getKey());
	}

}
