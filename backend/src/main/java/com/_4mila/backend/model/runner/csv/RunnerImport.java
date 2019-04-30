package com._4mila.backend.model.runner.csv;

import javax.persistence.Entity;

import com._4mila.backend.model.AbstractEntity;

@Entity
public class RunnerImport extends AbstractEntity implements Comparable<RunnerImport> {

	private String databaseId;

	private String familyName;

	private String firstName;

	private String year;

	private String city;

	public String getDatabaseId() {
		return databaseId;
	}

	public void setDatabaseId(String databaseId) {
		this.databaseId = databaseId;
	}

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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public int compareTo(RunnerImport o) {
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
