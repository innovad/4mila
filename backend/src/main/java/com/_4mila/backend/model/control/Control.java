package com._4mila.backend.model.control;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
	
	@Enumerated(EnumType.STRING)
	private ControlType type;

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
	
	public ControlType getType() {
		return type;
	}
	
	public void setType(ControlType type) {
		this.type = type;
	}

	@Override
	public int compareTo(Control o) {
		if (this.getId() != null && o.getId() != null) {
			int nameComparison = this.getId().compareTo(o.getId());
			if (nameComparison != 0) {
				return nameComparison;
			}
		}
		return this.getKey().compareTo(o.getKey());
	}

}
