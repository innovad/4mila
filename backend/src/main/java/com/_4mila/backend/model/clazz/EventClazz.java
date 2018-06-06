package com._4mila.backend.model.clazz;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com._4mila.backend.model.AbstractEntity;
import com._4mila.backend.model.event.Event;

@Entity
@Table(name = "EventClass", uniqueConstraints = { @UniqueConstraint(columnNames = { "event_key", "class_key" }) })
public class EventClazz extends AbstractEntity implements Comparable<EventClazz> {

	@ManyToOne
	private Event event;

	@ManyToOne
	@JoinColumn(name = "class_key")
	private Clazz clazz;

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Clazz getClazz() {
		return clazz;
	}

	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}

	@Override
	public int compareTo(EventClazz o) {
		int nameComparison = this.getClazz().compareTo(o.getClazz());
		if (nameComparison != 0) {
			return nameComparison;
		}
		return this.getKey().compareTo(o.getKey());
	}

}
