package com._4mila.backend.model.ecard;

import javax.persistence.Entity;

import com._4mila.backend.model.AbstractEntity;

@Entity
public class Ecard extends AbstractEntity implements Comparable<Ecard> {
	
	private String id;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public int compareTo(Ecard o) {
		return this.getKey().compareTo(o.getKey());
	}

}
