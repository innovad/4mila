package com._4mila.backend.service.ecard;

import com._4mila.backend.model.ecard.Ecard;
import com._4mila.backend.service.AbstractCrudRestService;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class EcardRestService extends AbstractCrudRestService<Ecard, Long> {

	@Inject
	public EcardRestService(Injector injector) {
		super(injector, EcardDatabaseService.class);
	}

}
