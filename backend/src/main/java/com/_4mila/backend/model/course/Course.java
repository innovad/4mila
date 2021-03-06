package com._4mila.backend.model.course;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com._4mila.backend.model.AbstractEntity;
import com._4mila.backend.model.clazz.EventClazz;
import com._4mila.backend.model.event.Event;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "event_key", "name" }) })
public class Course extends AbstractEntity implements Comparable<Course> {

	private String name;
	
	private String climb;
	
	private String length;

	@ManyToOne
	private Event event;

	@OneToMany (mappedBy = "course")
	private Set<CourseControl> courseControls = new HashSet<>();
	
	@OneToMany (mappedBy = "course")
	private Set<EventClazz> eventClasses = new HashSet<>();
	
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
	
	public Set<CourseControl> getCourseControls() {
		return courseControls;
	}
	
	public Set<EventClazz> getEventClasses() {
		return eventClasses;
	}
	
	public String getClimb() {
		return climb;
	}
	
	public void setClimb(String climb) {
		this.climb = climb;
	}
	
	public String getLength() {
		return length;
	}
	
	public void setLength(String length) {
		this.length = length;
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
