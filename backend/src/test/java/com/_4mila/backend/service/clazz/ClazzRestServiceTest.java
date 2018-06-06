package com._4mila.backend.service.clazz;

import com._4mila.backend.model.clazz.Clazz;
import com._4mila.backend.service.AbstractCrudRestServiceTest;

public class ClazzRestServiceTest extends AbstractCrudRestServiceTest<Clazz, Long> {

	@Override
	protected Class<?> getService() {
		return ClazzRestService.class;
	}

	@Override
	protected Class<Clazz> getEntityClass() {
		return Clazz.class;
	}

}
