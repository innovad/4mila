package com._4mila.backend.service.entry;

import com._4mila.backend.model.entry.Entry;
import com._4mila.backend.service.AbstractCrudRestServiceTest;

public class EntryRestServiceTest extends AbstractCrudRestServiceTest<Entry, Long> {

	@Override
	protected Class<?> getService() {
		return EntryRestService.class;
	}

	@Override
	protected Class<Entry> getEntityClass() {
		return Entry.class;
	}
	
}
