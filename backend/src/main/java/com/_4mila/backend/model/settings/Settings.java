package com._4mila.backend.model.settings;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com._4mila.backend.model.AbstractEntity;
import com._4mila.backend.model.event.Event;

@Entity
public class Settings extends AbstractEntity {

	@ManyToOne
	private Event defaultEvent;
	
	public Event getDefaultEvent() {
		return defaultEvent;
	}
	
	public void setDefaultEvent(Event defaultEvent) {
		this.defaultEvent = defaultEvent;
	}

}
