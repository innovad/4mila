package com._4mila.backend.service.course.iof2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com._4mila.backend.model.control.Control;
import com._4mila.backend.model.course.Course;
import com._4mila.backend.model.course.iof2.CourseImport;
import com._4mila.backend.model.event.Event;
import com._4mila.backend.service.AbstractCrudRestServiceTest;
import com._4mila.backend.service.control.ControlDatabaseService;
import com._4mila.backend.service.course.CourseControlDatabaseService;
import com._4mila.backend.service.course.CourseDatabaseService;
import com._4mila.backend.service.event.EventDatabaseService;


public class CourseImportRestServiceTest extends AbstractCrudRestServiceTest<CourseImport, Long> {

	private Event event;
	
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
		
		CourseControlDatabaseService courseControlDatabaseService = getInjector().getInstance(CourseControlDatabaseService.class);
		int initialCourseControlCount = courseControlDatabaseService.list().size();
		
		String url = "/upload/event/" + event.getKey() + "/course";
		String jsonResult = testPost(url, "iof2_coursedata.xml");
		assertNotNull("fileKey", jsonResult);
		assertEquals(initialCourseCount + 4, courseDatabaseService.list().size());
		assertEquals(initialControlCount + 28, controlDatabaseService.list().size());
		assertEquals(initialCourseControlCount + 99, courseControlDatabaseService.list().size());
		
		jsonResult = testPost(url, "iof2_coursedata.xml");
		assertNotNull("fileKey", jsonResult);
		assertEquals(initialCourseCount + 4, courseDatabaseService.list().size());		
		assertEquals(initialControlCount + 28, controlDatabaseService.list().size());
		assertEquals(initialCourseControlCount + 99, courseControlDatabaseService.list().size());
	}
	
	@Test
	public void testFileWithBOM() throws Exception {
		String url = "/upload/event/" + event.getKey() + "/course";
		String jsonResult = testPost(url, "iof2_coursedataBOM.xml");
		assertNotNull("fileKey", jsonResult);
	}
	
	@Before
	public void prepare() {
		EventDatabaseService eventDatabaseService = getInjector().getInstance(EventDatabaseService.class);
		event = new Event();
		eventDatabaseService.create(event);
	}
	
	@After
	public void cleanup() {
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
