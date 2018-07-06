package com._4mila.backend.model.race;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import com._4mila.backend.model.AbstractEntity;
import com._4mila.backend.model.course.CourseControl;

@Entity
public class RaceControl extends AbstractEntity implements Comparable<RaceControl> {

	@ManyToOne
	private Race race;

	@ManyToOne
	private CourseControl courseControl;

	private long sortOrder;

	private Long lapTime;

	private Long overallTime;

	private Long shiftTime;

	@Enumerated(EnumType.STRING)
	private RaceControlStatus status;
	
	public RaceControlStatus getStatus() {
		return status;
	}

	public CourseControl getCourseControl() {
		return courseControl;
	}

	public void setCourseControl(CourseControl courseControl) {
		this.courseControl = courseControl;
	}

	public Long getLapTime() {
		return lapTime;
	}

	public void setLapTime(Long lapTime) {
		this.lapTime = lapTime;
	}

	public Long getOverallTime() {
		return overallTime;
	}

	public void setOverallTime(Long overallTime) {
		this.overallTime = overallTime;
	}

	public Long getShiftTime() {
		return shiftTime;
	}

	public void setShiftTime(Long shiftTime) {
		this.shiftTime = shiftTime;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public long getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(long sortOrder) {
		this.sortOrder = sortOrder;
	}

	@Override
	public int compareTo(RaceControl o) {
		return this.getKey().compareTo(o.getKey());
	}

}
