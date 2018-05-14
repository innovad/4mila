package com._4mila.backend.service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;

import com.google.inject.Inject;
import com.google.inject.Provider;

public abstract class AbstractDatabaseService {

	
	@Inject
	private Provider<EntityManager> em;
		
	public AbstractDatabaseService() {
	}

	protected Provider<EntityManager> getEntityManager() {
		return em;
	}
	
	protected final CriteriaBuilder getCriteriaBuilder() {
		return getEntityManager().get().getCriteriaBuilder();
	}
		
}
