package com._4mila.backend.model.runner;

import java.time.LocalDate;

import javax.persistence.Entity;

import com._4mila.backend.model.AbstractEntity;

@Entity
public class Runner extends AbstractEntity implements Comparable<Runner> {

	private String familyName;

	private String firstName;

	private LocalDate birthDate;

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
