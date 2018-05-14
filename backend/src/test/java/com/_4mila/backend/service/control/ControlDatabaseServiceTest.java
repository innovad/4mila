package com._4mila.backend.service.control;

import com._4mila.backend.model.control.Control;
import com._4mila.backend.service.AbstractCrudDatabaseServiceTest;

public class ControlDatabaseServiceTest extends AbstractCrudDatabaseServiceTest<Control, Long> {

	@Override
	protected Class<?> getService() {
		return ControlDatabaseService.class;
	}

	@Override
	protected Class<Control> getEntity() {
		return Control.class;
	}
	

}