package com._4mila.backend.service.ecard;

import com._4mila.backend.model.ecard.Ecard;
import com._4mila.backend.service.AbstractCrudRestServiceTest;

public class ECardRestServiceTest extends AbstractCrudRestServiceTest<Ecard, Long> {

	@Override
	protected Class<?> getService() {
		return EcardRestService.class;
	}

	@Override
	protected Class<Ecard> getEntityClass() {
		return Ecard.class;
	}
	
}
