package com._4mila.backend.model.course;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com._4mila.backend.model.AbstractEntity;
import com._4mila.backend.model.event.Event;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "event_key", "name" }) })
public class Course extends AbstractEntity implements Comparable<Course> {

	private String name;

	@ManyToOne
	private Event event;

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	@Override
	public int compareTo(Course o) {
		int nameComparison = this.getName().compareTo(o.getName());
		if (nameComparison != 0) {
			return nameComparison;
		}
		return this.getKey().compareTo(o.getKey());
	}

}
