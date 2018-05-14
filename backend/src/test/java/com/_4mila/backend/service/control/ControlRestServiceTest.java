package com._4mila.backend.service.control;

import com._4mila.backend.model.control.Control;
import com._4mila.backend.service.AbstractCrudRestServiceTest;

public class ControlRestServiceTest extends AbstractCrudRestServiceTest<Control, Long> {

	@Override
	protected Class<?> getService() {
		return ControlRestService.class;
	}

	@Override
	protected Class<Control> getEntityClass() {
		return Control.class;
	}
	
}
