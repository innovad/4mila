package com._4mila.backend.service.clazz;

import com._4mila.backend.model.clazz.Clazz;
import com._4mila.backend.service.AbstractCrudDatabaseServiceTest;

public class ClazzDatabaseServiceTest extends AbstractCrudDatabaseServiceTest<Clazz, Long> {

	@Override
	protected Class<?> getService() {
		return ClazzDatabaseService.class;
	}

	@Override
	protected Class<Clazz> getEntity() {
		return Clazz.class;
	}
	

}