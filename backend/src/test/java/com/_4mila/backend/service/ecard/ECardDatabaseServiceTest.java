package com._4mila.backend.service.ecard;

import com._4mila.backend.model.ecard.Ecard;
import com._4mila.backend.service.AbstractCrudDatabaseServiceTest;

public class ECardDatabaseServiceTest extends AbstractCrudDatabaseServiceTest<Ecard, Long> {

	@Override
	protected Class<?> getService() {
		return EcardDatabaseService.class;
	}

	@Override
	protected Class<Ecard> getEntity() {
		return Ecard.class;
	}
	

}