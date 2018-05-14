package com._4mila.backend.service;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.google.common.base.CaseFormat;
import com.google.common.base.MoreObjects;
import com.google.inject.persist.Transactional;

public abstract class AbstractCrudDatabaseService<ENTITY, KEYTYPE> extends AbstractDatabaseService {

	/**
	 * @return runtime class, compiler cannot detect it, see http://stackoverflow.com/questions/16799129/java-generics-get- classt-of-generic-parameter
	 */
	public abstract Class<ENTITY> getEntityClass();
	
	@SafeVarargs
	public final List<ENTITY> list(AbstractListFilter... filters) {
		return list(null, filters);
	}
	
	@SafeVarargs
	public final List<ENTITY> list(Integer maxResults, AbstractListFilter... filters) {	
		CriteriaQuery<ENTITY> criteriaQuery = getCriteriaBuilder().createQuery(getEntityClass());
		Root<ENTITY> root = criteriaQuery.from(getEntityClass());
		criteriaQuery.select(root);
		for (AbstractListFilter filter : filters) {
			filter.appendFilter(criteriaQuery, root);
		}
		List<Order> orderList = new ArrayList<>();
		orderBy(root, orderList);
		criteriaQuery.orderBy(orderList);
		TypedQuery<ENTITY> typedQuery = getEntityManager().get().createQuery(criteriaQuery);
		if (maxResults != null) {
			typedQuery.setMaxResults(maxResults);
		}
		return typedQuery.getResultList();
	}
	
	protected void orderBy(Root<ENTITY> root, List<Order> orderList) {
	}

	protected void afterRead(ENTITY entity) {
	}
	
	public ENTITY read(KEYTYPE id) {
		ENTITY entity = getEntityManager().get().find(getEntityClass(), id);
		afterRead(entity);
		return entity;
	}

	protected void beforeUpdate(ENTITY entity) {
	}
	
	@Transactional
	public boolean update(ENTITY entity) {
		beforeUpdate(entity);
		getEntityManager().get().merge(entity);
		return true;
	}

	protected void beforeCreate(ENTITY entity) {
	}

	protected void afterCreate(ENTITY entity) {
	}

	@Transactional
	public ENTITY create(ENTITY entity) {
		beforeCreate(entity);
		getEntityManager().get().persist(entity);
		afterCreate(entity);
		return entity;
	}

	protected void beforeDelete(ENTITY entity) {
	}
	
	@Transactional
	public boolean delete(ENTITY entity) {
		beforeDelete(entity);
		getEntityManager().get().remove(getEntityManager().get().contains(entity) ? entity : getEntityManager().get().merge(entity));
		return true;
	}

	public List<PathListEntry<KEYTYPE>> createPathList(Collection<ENTITY> resultList) {
		List<PathListEntry<KEYTYPE>> result = new ArrayList<>();
		for (ENTITY element : resultList) {
			PathListEntry<KEYTYPE> entry = new PathListEntry<>();
			createPathListEntry(element, entry);
			result.add(entry);
		}
		return result;
	}

	public abstract void createPathListEntry(ENTITY entity, PathListEntry<KEYTYPE> entry);

	public abstract class AbstractListFilter {
		protected void addPredicate(CriteriaQuery<ENTITY> criteriaQuery, Predicate predicate) {
			criteriaQuery.where(MoreObjects.firstNonNull(criteriaQuery.getRestriction(), getCriteriaBuilder().and()), predicate);
		}
		
		public abstract void appendFilter(CriteriaQuery<ENTITY> criteriaQuery, Root<ENTITY> root);
	}

	protected String getKeyName() {
		// find highest non-abstract super class for automatic key name
		Class<?> entityClass = getNonAbstractSuperclass();
		return CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, entityClass.getSimpleName() + "Key");
	}

	private Class<?> getNonAbstractSuperclass() {
		Class<?> entityClass = getEntityClass();
		while (entityClass.getSuperclass() != null && entityClass.getSuperclass() != Object.class && !Modifier.isAbstract(entityClass.getSuperclass().getModifiers())) {
			entityClass = entityClass.getSuperclass();
		}
		return entityClass;
	}

}
