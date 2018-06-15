package com._4mila.backend.service.course;

import com._4mila.backend.model.course.CourseControl;
import com._4mila.backend.service.AbstractCrudDatabaseServiceTest;

public class CourseControlDatabaseServiceTest extends AbstractCrudDatabaseServiceTest<CourseControl, Long> {

	@Override
	protected Class<?> getService() {
		return CourseControlDatabaseService.class;
	}

	@Override
	protected Class<CourseControl> getEntity() {
		return CourseControl.class;
	}
	

}