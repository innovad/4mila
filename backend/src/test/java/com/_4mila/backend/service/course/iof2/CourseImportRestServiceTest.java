package com._4mila.backend.service.course.iof2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com._4mila.backend.model.control.Control;
import com._4mila.backend.model.course.Course;
import com._4mila.backend.model.course.iof2.CourseImport;
import com._4mila.backend.model.event.Event;
import com._4mila.backend.service.AbstractCrudRestServiceTest;
import com._4mila.backend.service.control.ControlDatabaseService;
import com._4mila.backend.service.course.CourseDatabaseService;
import com._4mila.backend.service.event.EventDatabaseService;


public class CourseImportRestServiceTest extends AbstractCrudRestServiceTest<CourseImport, Long> {

	private static Event event;
	
	@Override
	protected Class<?> getService() {
		return CourseImportRestService.class;
	}

	@Override
	protected Class<CourseImport> getEntityClass() {
		return CourseImport.class;
	}
		
	@Test
	public void testMultipleUpload() throws Exception {
		CourseDatabaseService courseDatabaseService = getInjector().getInstance(CourseDatabaseService.class);
		int initialCourseCount = courseDatabaseService.list().size();
		
		ControlDatabaseService controlDatabaseService = getInjector().getInstance(ControlDatabaseService.class);
		int initialControlCount = controlDatabaseService.list().size();
		
		String url = "/upload/event/" + event.getKey() + "/course";
		String jsonResult = testPost(url, "coursedata_iof2.xml");
		assertNotNull("fileKey", jsonResult);
		assertEquals(initialCourseCount + 4, courseDatabaseService.list().size());
		assertEquals(initialControlCount + 26, controlDatabaseService.list().size());
		
		jsonResult = testPost(url, "coursedata_iof2.xml");
		assertNotNull("fileKey", jsonResult);
		assertEquals(initialCourseCount + 4, courseDatabaseService.list().size());		
		assertEquals(initialControlCount + 26, controlDatabaseService.list().size());
	}
	
	@BeforeClass
	public static void prepare() {
		EventDatabaseService eventDatabaseService = getInjector().getInstance(EventDatabaseService.class);
		event = new Event();
		eventDatabaseService.create(event);
	}
	
	@AfterClass
	public static void cleanup() {
		CourseDatabaseService courseDatabaseService = getInjector().getInstance(CourseDatabaseService.class);
		ControlDatabaseService controlDatabaseService = getInjector().getInstance(ControlDatabaseService.class);
		EventDatabaseService eventDatabaseService = getInjector().getInstance(EventDatabaseService.class);
		
		for (Course course : courseDatabaseService.list()) {
			courseDatabaseService.delete(course);
		}
		
		for (Control control : controlDatabaseService.list()) {
			controlDatabaseService.delete(control);
		}
		
		eventDatabaseService.delete(event);
	}
	
}
