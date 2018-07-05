package com._4mila.backend.model.runner;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com._4mila.backend.model.AbstractEntity;
import com._4mila.backend.model.ecard.Ecard;

@Entity
public class Runner extends AbstractEntity implements Comparable<Runner> {

	private String familyName;

	private String firstName;

	private LocalDate birthDate;
	
	@ManyToOne
	private Ecard defaultEcard;

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	public Ecard getDefaultEcard() {
		return defaultEcard;
	}
	
	public void setDefaultEcard(Ecard defaultEcard) {
		this.defaultEcard = defaultEcard;
	}

	@Transient
	public String getName() {
		return this.getFamilyName() + " " + this.getFirstName();
	}
	
	@Override
	public int compareTo(Runner o) {
		int nameComparison = this.getFamilyName().compareTo(o.getFamilyName());
		if (nameComparison != 0) {
			return nameComparison;
		}
		nameComparison = this.getFirstName().compareTo(o.getFirstName());
		if (nameComparison != 0) {
			return nameComparison;
		}
		return this.getKey().compareTo(o.getKey());
	}

}
