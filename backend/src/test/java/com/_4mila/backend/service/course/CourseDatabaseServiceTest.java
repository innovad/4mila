package com._4mila.backend.service.course;

import com._4mila.backend.model.course.Course;
import com._4mila.backend.service.AbstractCrudDatabaseServiceTest;

public class CourseDatabaseServiceTest extends AbstractCrudDatabaseServiceTest<Course, Long> {

	@Override
	protected Class<?> getService() {
		return CourseDatabaseService.class;
	}

	@Override
	protected Class<Course> getEntity() {
		return Course.class;
	}
	

}