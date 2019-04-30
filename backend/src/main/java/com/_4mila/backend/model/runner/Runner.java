package com._4mila.backend.model.runner;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com._4mila.backend.model.AbstractEntity;
import com._4mila.backend.model.ecard.Ecard;

@Entity
public class Runner extends AbstractEntity implements Comparable<Runner> {

	private String familyName;

	private String firstName;

	private Integer yearOfBirth;

	private String sex;

	private String city;

	private String email;
	
	private String id;

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

	public Ecard getDefaultEcard() {
		return defaultEcard;
	}

	public void setDefaultEcard(Ecard defaultEcard) {
		this.defaultEcard = defaultEcard;
	}

	public Integer getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(Integer yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
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
