package com._4mila.backend.service.entry;

import com._4mila.backend.model.entry.Entry;
import com._4mila.backend.service.AbstractCrudDatabaseServiceTest;

public class EntryDatabaseServiceTest extends AbstractCrudDatabaseServiceTest<Entry, Long> {

	@Override
	protected Class<?> getService() {
		return EntryDatabaseService.class;
	}

	@Override
	protected Class<Entry> getEntity() {
		return Entry.class;
	}
	

}