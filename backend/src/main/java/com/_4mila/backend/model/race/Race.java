package com._4mila.backend.model.race;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com._4mila.backend.model.AbstractEntity;
import com._4mila.backend.model.clazz.EventClazz;
import com._4mila.backend.model.ecard.Ecard;
import com._4mila.backend.model.entry.Entry;
import com._4mila.backend.model.runner.Runner;

@Entity
public class Race extends AbstractEntity implements Comparable<Race> {

	@ManyToOne
	private EventClazz eventClazz;
	
	@ManyToOne
	private Runner runner;

	@ManyToOne
	private Entry entry;

	@ManyToOne
	private Ecard ecard;
	
	@OneToMany (mappedBy = "race")
	private Set<RaceControl> raceControls = new HashSet<>();
	
	@Enumerated(EnumType.STRING)
    private RaceStatus status;
	
	public Set<RaceControl> getRaceControls() {
		return raceControls;
	}
	
	public EventClazz getEventClazz() {
		return eventClazz;
	}
	
	public void setEventClazz(EventClazz eventClazz) {
		this.eventClazz = eventClazz;
	}
		
	public Entry getEntry() {
		return entry;
	}
	
	public void setEntry(Entry entry) {
		this.entry = entry;
	}
	
	public Runner getRunner() {
		return runner;
	}
	
	public void setRunner(Runner runner) {
		this.runner = runner;
	}
	
	public Ecard getEcard() {
		return ecard;
	}
	
	public void setEcard(Ecard ecard) {
		this.ecard = ecard;
	}
	
	public void setStatus(RaceStatus status) {
		this.status = status;
	}
	
	public RaceStatus getStatus() {
		return status;
	}
	
	@Override
	public int compareTo(Race o) {
		return this.getKey().compareTo(o.getKey());
	}

}
