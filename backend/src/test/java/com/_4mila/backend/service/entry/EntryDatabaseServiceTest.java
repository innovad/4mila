package com._4mila.backend.service.entry;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com._4mila.backend.model.clazz.Clazz;
import com._4mila.backend.model.clazz.EventClazz;
import com._4mila.backend.model.entry.Entry;
import com._4mila.backend.model.event.Event;
import com._4mila.backend.model.race.Race;
import com._4mila.backend.model.runner.Runner;
import com._4mila.backend.service.AbstractCrudDatabaseServiceTest;
import com._4mila.backend.service.clazz.ClazzDatabaseService;
import com._4mila.backend.service.clazz.EventClazzDatabaseService;
import com._4mila.backend.service.event.EventDatabaseService;
import com._4mila.backend.service.race.RaceDatabaseService;
import com._4mila.backend.service.runner.RunnerDatabaseService;

public class EntryDatabaseServiceTest extends AbstractCrudDatabaseServiceTest<Entry, Long> {
	
	@Override
	protected Class<?> getService() {
		return EntryDatabaseService.class;
	}

	@Override
	protected Class<Entry> getEntity() {
		return Entry.class;
	}

	@Test
	public void testNewEntry() throws Exception {
		Clazz clazz = getInjector().getInstance(ClazzDatabaseService.class).create(new Clazz());
		Event event = getInjector().getInstance(EventDatabaseService.class).create(new Event());
		EventClazz eventClazz = new EventClazz();
		eventClazz.setClazz(clazz);
		eventClazz.setEvent(event);
		eventClazz = getInjector().getInstance(EventClazzDatabaseService.class).create(eventClazz);
		Runner runner = getInjector().getInstance(RunnerDatabaseService.class).create(new Runner());
		EntryDatabaseService svc = getInjector().getInstance(EntryDatabaseService.class);
		Race race = svc.createEntryWithRace(runner.getKey(), eventClazz.getKey());
		
		assertNotNull("entry must exist", race.getEntry());
		
		getInjector().getInstance(RaceDatabaseService.class).delete(race);
		svc.delete(race.getEntry());
		getInjector().getInstance(EventClazzDatabaseService.class).delete(eventClazz);
		getInjector().getInstance(RunnerDatabaseService.class).delete(runner);
		getInjector().getInstance(EventDatabaseService.class).delete(event);
		getInjector().getInstance(ClazzDatabaseService.class).delete(clazz);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNewEntryNull1() throws Exception {
		EntryDatabaseService svc = getInjector().getInstance(EntryDatabaseService.class);
		svc.createEntryWithRace(null, null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNewEntryNull2() throws Exception {
		EntryDatabaseService svc = getInjector().getInstance(EntryDatabaseService.class);
		svc.createEntryWithRace(1L, null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNewEntryNull3() throws Exception {
		EntryDatabaseService svc = getInjector().getInstance(EntryDatabaseService.class);
		svc.createEntryWithRace(null, 1L);
	}

}