package com._4mila.backend.service.control;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com._4mila.backend.model.control.Control;
import com._4mila.backend.model.event.Event;
import com._4mila.backend.service.AbstractCrudRestServiceTest;
import com._4mila.backend.service.PathListEntry;
import com._4mila.backend.service.event.EventDatabaseService;

public class ControlRestServiceTest extends AbstractCrudRestServiceTest<Control, Long> {

	@Override
	protected Class<?> getService() {
		return ControlRestService.class;
	}

	@Override
	protected Class<Control> getEntityClass() {
		return Control.class;
	}

	@Test
	public void testGetEventControls() throws Exception {
		ControlDatabaseService controlDatabaseService = getInjector().getInstance(ControlDatabaseService.class);
		EventDatabaseService eventDatabaseService = getInjector().getInstance(EventDatabaseService.class);

		Event e = new Event();
		eventDatabaseService.create(e);
		Control c1 = new Control();
		c1.setEvent(e);
		controlDatabaseService.create(c1);
		Control c2 = new Control();
		c2.setEvent(e);
		controlDatabaseService.create(c2);

		String jsonResult = testGet("event/" + e.getKey() + "/control");
		List<PathListEntry<Long>> result = parsePathListJson(jsonResult);
		assertEquals("2 controls", 2, result.size());

		controlDatabaseService.delete(c2);
		controlDatabaseService.delete(c1);
		eventDatabaseService.delete(e);
	}

}
