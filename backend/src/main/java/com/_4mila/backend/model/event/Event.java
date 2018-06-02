package com._4mila.backend.model.event;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com._4mila.backend.model.AbstractEntity;
import com._4mila.backend.model.control.Control;
import com._4mila.backend.model.course.Course;

@Entity
public class Event extends AbstractEntity implements Comparable<Event> {

	private String name;

	@OneToMany (mappedBy = "event")
	private Set<Control> controls = new HashSet<>();

	@OneToMany (mappedBy = "event")
	private Set<Course> courses = new HashSet<>();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Set<Control> getControls() {
		return controls;
	}
	
	public Set<Course> getCourses() {
		return courses;
	}

	@Override
	public int compareTo(Event o) {
		int nameComparison = this.getName().compareTo(o.getName());
		if (nameComparison != 0) {
			return nameComparison;
		}
		return this.getKey().compareTo(o.getKey());
	}

}
