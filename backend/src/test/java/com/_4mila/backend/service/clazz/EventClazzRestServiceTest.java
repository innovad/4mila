package com._4mila.backend.service.clazz;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com._4mila.backend.model.clazz.EventClazz;
import com._4mila.backend.model.event.Event;
import com._4mila.backend.service.AbstractCrudRestServiceTest;
import com._4mila.backend.service.PathListEntry;
import com._4mila.backend.service.event.EventDatabaseService;

public class EventClazzRestServiceTest extends AbstractCrudRestServiceTest<EventClazz, Long> {
	
	@Override
	protected Class<?> getService() {
		return EventClazzRestService.class;
	}

	@Override
	protected Class<EventClazz> getEntityClass() {
		return EventClazz.class;
	}
	
	@Test
	public void testGetEventEventClazzes() throws Exception {
		EventClazzDatabaseService eventClazzDatabaseService = getInjector().getInstance(EventClazzDatabaseService.class);
		EventDatabaseService eventDatabaseService = getInjector().getInstance(EventDatabaseService.class);

		Event e = new Event();
		eventDatabaseService.create(e);
		EventClazz c1 = new EventClazz();
		c1.setEvent(e);
		eventClazzDatabaseService.create(c1);
		EventClazz c2 = new EventClazz();
		c2.setEvent(e);
		eventClazzDatabaseService.create(c2);

		String jsonResult = testGet("event/" + e.getKey() + "/eventClazz");
		List<PathListEntry<Long>> result = parsePathListJson(jsonResult);
		assertEquals("2 event clazzes", 2, result.size());

		eventClazzDatabaseService.delete(c2);
		eventClazzDatabaseService.delete(c1);
		eventDatabaseService.delete(e);
	}
	
	@Test
	public void testGetEventEventClazzesSummary() throws Exception {
		EventClazzDatabaseService eventClazzDatabaseService = getInjector().getInstance(EventClazzDatabaseService.class);
		EventDatabaseService eventDatabaseService = getInjector().getInstance(EventDatabaseService.class);

		Event e = new Event();
		eventDatabaseService.create(e);
		EventClazz c1 = new EventClazz();
		c1.setEvent(e);
		eventClazzDatabaseService.create(c1);
		EventClazz c2 = new EventClazz();
		c2.setEvent(e);
		eventClazzDatabaseService.create(c2);

		String jsonResult = testGet("event/" + e.getKey() + "/eventClazz/summary");
		List<PathListEntry<Long>> result = parsePathListJson(jsonResult);
		assertEquals("1 button", 1, result.size());
		assertEquals("2 classes", "2", result.get(0).getDetails().get(0));

		eventClazzDatabaseService.delete(c2);
		eventClazzDatabaseService.delete(c1);
		eventDatabaseService.delete(e);
	}
	
	
}
