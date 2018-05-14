package com._4mila.backend.model.control;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com._4mila.backend.model.AbstractEntity;
import com._4mila.backend.model.event.Event;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "event_key", "id" }) })
public class Control extends AbstractEntity implements Comparable<Control> {

	private String id;

	@ManyToOne
	private Event event;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	@Override
	public int compareTo(Control o) {
		int nameComparison = this.getId().compareTo(o.getId());
		if (nameComparison != 0) {
			return nameComparison;
		}
		return this.getKey().compareTo(o.getKey());
	}

}
