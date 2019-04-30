package com._4mila.backend.model.ecard;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com._4mila.backend.model.AbstractEntity;
import com._4mila.backend.model.runner.Runner;

@Entity
public class Ecard extends AbstractEntity implements Comparable<Ecard> {
	
	private String id;
	
	@OneToMany(mappedBy = "defaultEcard")
	private List<Runner> runners = new ArrayList<>();
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public List<Runner> getRunners() {
		return runners;
	}
	
	@Override
	public int compareTo(Ecard o) {
		return this.getKey().compareTo(o.getKey());
	}

}
