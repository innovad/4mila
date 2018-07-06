package com._4mila.backend.service.entry;

import java.util.List;

import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import com._4mila.backend.model.clazz.EventClazz;
import com._4mila.backend.model.entry.Entry;
import com._4mila.backend.model.entry.Entry_;
import com._4mila.backend.model.race.Race;
import com._4mila.backend.model.race.RaceStatus;
import com._4mila.backend.model.runner.Runner;
import com._4mila.backend.service.AbstractCrudDatabaseService;
import com._4mila.backend.service.PathListEntry;
import com._4mila.backend.service.clazz.EventClazzDatabaseService;
import com._4mila.backend.service.race.RaceDatabaseService;
import com._4mila.backend.service.runner.RunnerDatabaseService;
import com.google.inject.Inject;

public class EntryDatabaseService extends AbstractCrudDatabaseService<Entry, Long> {

	@Inject
	RaceDatabaseService raceDatabaseService;
	
	@Inject
	RunnerDatabaseService runnerDatabaseService;
	
	@Inject
	EventClazzDatabaseService eventClazzDatabaseService;
	
	@Override
	public Class<Entry> getEntityClass() {
		return Entry.class;
	}

	@Override
	public void createPathListEntry(Entry entity, PathListEntry<Long> entry) {
		entry.setKey(entity.getKey(), getKeyName());
		entry.setName("" + entity.getKey());
	}

	@Override
	protected void orderBy(Root<Entry> root, List<Order> orderList) {
		orderList.add(getCriteriaBuilder().asc(root.get(Entry_.key)));
	}
	
	public Race createEntryWithRace(Long runnerKey, Long eventClazzKey) {
		if (runnerKey == null || eventClazzKey == null) {
			throw new IllegalArgumentException("runner and eventClass key required");
		}
		Entry entry = new Entry();
		entry = create(entry);
		
		Runner runner = runnerDatabaseService.read(runnerKey);
		EventClazz eventClazz = eventClazzDatabaseService.read(eventClazzKey);	
		
		Race race = new Race();
		race.setEntry(entry);
		race.setEventClazz(eventClazz);
		race.setRunner(runner);
		race.setEcard(runner.getDefaultEcard());
		race.setStatus(RaceStatus.DidNotStart);
		raceDatabaseService.create(race);
		return race;
	}

}