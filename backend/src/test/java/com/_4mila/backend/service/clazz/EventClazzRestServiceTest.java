package com._4mila.backend.service.clazz;

import com._4mila.backend.model.clazz.EventClazz;
import com._4mila.backend.service.AbstractCrudRestServiceTest;

public class EventClazzRestServiceTest extends AbstractCrudRestServiceTest<EventClazz, Long> {
	
	@Override
	protected Class<?> getService() {
		return EventClazzRestService.class;
	}

	@Override
	protected Class<EventClazz> getEntityClass() {
		return EventClazz.class;
	}
	
}
