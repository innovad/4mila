package com._4mila.backend.model.control;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com._4mila.backend.model.AbstractEntity;
import com._4mila.backend.model.event.Event;

@Entity
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

	@Override
	public int compareTo(Control o) {
		int nameComparison = this.getId().compareTo(o.getId());
		if (nameComparison != 0) {
			return nameComparison;
		}
		return this.getKey().compareTo(o.getKey());
	}

}
