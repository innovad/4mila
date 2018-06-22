package com._4mila.backend.model.clazz;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com._4mila.backend.model.AbstractEntity;

@Entity
@Table(name = "Class", uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }) })
public class Clazz extends AbstractEntity implements Comparable<Clazz> {

	private String name;

	@OneToMany (mappedBy = "clazz")
	private Set<EventClazz> eventClasses = new HashSet<>();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Set<EventClazz> getEventClasses() {
		return eventClasses;
	}
	
	@Override
	public int compareTo(Clazz o) {
		int nameComparison = this.getName().compareTo(o.getName());
		if (nameComparison != 0) {
			return nameComparison;
		}
		return this.getKey().compareTo(o.getKey());
	}

}
