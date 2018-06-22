package com._4mila.backend.service.course;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com._4mila.backend.model.course.Course;
import com._4mila.backend.model.event.Event;
import com._4mila.backend.service.AbstractCrudRestServiceTest;
import com._4mila.backend.service.PathListEntry;
import com._4mila.backend.service.event.EventDatabaseService;

public class CourseRestServiceTest extends AbstractCrudRestServiceTest<Course, Long> {

	@Override
	protected Class<?> getService() {
		return CourseRestService.class;
	}

	@Override
	protected Class<Course> getEntityClass() {
		return Course.class;
	}

	@Test
	public void testGetEventCourses() throws Exception {
		CourseDatabaseService courseDatabaseService = getInjector().getInstance(CourseDatabaseService.class);
		EventDatabaseService eventDatabaseService = getInjector().getInstance(EventDatabaseService.class);

		Event e = new Event();
		eventDatabaseService.create(e);
		Course c1 = new Course();
		c1.setEvent(e);
		courseDatabaseService.create(c1);
		Course c2 = new Course();
		c2.setEvent(e);
		courseDatabaseService.create(c2);

		String jsonResult = testGet("event/" + e.getKey() + "/course");
		List<PathListEntry<Long>> result = parsePathListJson(jsonResult);
		assertEquals("2 courses", 2, result.size());

		courseDatabaseService.delete(c2);
		courseDatabaseService.delete(c1);
		eventDatabaseService.delete(e);
	}
	
	@Test
	public void testGetEventCoursesSummary() throws Exception {
		CourseDatabaseService courseDatabaseService = getInjector().getInstance(CourseDatabaseService.class);
		EventDatabaseService eventDatabaseService = getInjector().getInstance(EventDatabaseService.class);

		Event e = new Event();
		eventDatabaseService.create(e);
		Course c1 = new Course();
		c1.setEvent(e);
		courseDatabaseService.create(c1);
		Course c2 = new Course();
		c2.setEvent(e);
		courseDatabaseService.create(c2);

		String jsonResult = testGet("event/" + e.getKey() + "/course/summary");
		List<PathListEntry<Long>> result = parsePathListJson(jsonResult);
		assertEquals("1 button", 1, result.size());
		assertEquals("2 courses", "2", result.get(0).getDetails().get(0));

		courseDatabaseService.delete(c2);
		courseDatabaseService.delete(c1);
		eventDatabaseService.delete(e);
	}

}
