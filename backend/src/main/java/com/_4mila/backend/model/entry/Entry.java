package com._4mila.backend.model.entry;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com._4mila.backend.model.AbstractEntity;
import com._4mila.backend.model.race.Race;

@Entity
public class Entry extends AbstractEntity implements Comparable<Entry> {
	
	@OneToMany (mappedBy = "entry")
	private Set<Race> races = new HashSet<>();
	
	public Set<Race> getRaces() {
		return races;
	}
	
	@Override
	public int compareTo(Entry o) {
		return this.getKey().compareTo(o.getKey());
	}

}
