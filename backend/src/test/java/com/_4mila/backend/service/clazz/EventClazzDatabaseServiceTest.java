package com._4mila.backend.service.clazz;

import com._4mila.backend.model.clazz.EventClazz;
import com._4mila.backend.service.AbstractCrudDatabaseServiceTest;

public class EventClazzDatabaseServiceTest extends AbstractCrudDatabaseServiceTest<EventClazz, Long> {

	@Override
	protected Class<?> getService() {
		return EventClazzDatabaseService.class;
	}

	@Override
	protected Class<EventClazz> getEntity() {
		return EventClazz.class;
	}
	

}