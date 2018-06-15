package com._4mila.backend.service.course;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com._4mila.backend.model.control.Control;
import com._4mila.backend.model.course.Course;
import com._4mila.backend.model.course.CourseControl;
import com._4mila.backend.model.event.Event;
import com._4mila.backend.service.AbstractCrudRestServiceTest;
import com._4mila.backend.service.PathListEntry;
import com._4mila.backend.service.control.ControlDatabaseService;
import com._4mila.backend.service.event.EventDatabaseService;

public class CourseControlRestServiceTest extends AbstractCrudRestServiceTest<CourseControl, Long> {

	@Override
	protected Class<?> getService() {
		return CourseControlRestService.class;
	}

	@Override
	protected Class<CourseControl> getEntityClass() {
		return CourseControl.class;
	}
	
	@Test
	public void testGetCourseCourseControls() throws Exception {
		ControlDatabaseService controlDatabaseService = getInjector().getInstance(ControlDatabaseService.class);
		CourseDatabaseService courseDatabaseService = getInjector().getInstance(CourseDatabaseService.class);
		EventDatabaseService eventDatabaseService = getInjector().getInstance(EventDatabaseService.class);
		CourseControlDatabaseService courseControlDatabaseService = getInjector().getInstance(CourseControlDatabaseService.class);

		Event e = new Event();
		eventDatabaseService.create(e);
		Control c1 = new Control();
		c1.setEvent(e);
		controlDatabaseService.create(c1);
		Control c2 = new Control();
		c2.setEvent(e);
		controlDatabaseService.create(c2);
		Course course = new Course();
		courseDatabaseService.create(course);
		CourseControl courseControl1 = new CourseControl();
		courseControl1.setControl(c1);
		courseControl1.setCourse(course);
		courseControl1.setSortOrder(1);
		courseControlDatabaseService.create(courseControl1);
		
		String jsonResult = testGet("course/" + course.getKey() + "/courseControl");
		List<PathListEntry<Long>> result = parsePathListJson(jsonResult);
		assertEquals("1 course control", 1, result.size());

		courseControlDatabaseService.delete(courseControl1);
		courseDatabaseService.delete(course);
		controlDatabaseService.delete(c2);
		controlDatabaseService.delete(c1);
		eventDatabaseService.delete(e);
	}	

}
