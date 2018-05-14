package com._4mila.backend.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com._4mila.backend.model.AbstractEntity;


public abstract class AbstractCrudDatabaseServiceTest<E extends AbstractEntity, KEYTYPE> extends AbstractDatabaseUnitTest {

	private AbstractCrudDatabaseService<E, KEYTYPE> service;

	protected abstract Class<?> getService();

	protected abstract Class<E> getEntity();
	
	protected void beforeCreate(E entity) {
	}

	@SuppressWarnings("unchecked")
	@Before
	public void before() throws Exception {
		service = (AbstractCrudDatabaseService<E, KEYTYPE>) getInjector().getInstance(getService());
	}
	
	@Test
	public void testList() throws Exception {
		List<E> entities = service.list();
		assertEquals(0, entities.size());
		E entity = getInjector().getInstance(getEntity());
		beforeCreate(entity);
		service.create(entity);
		entities = service.list();
		assertEquals(1, entities.size());
		service.delete(entity);
		entities = service.list();
		assertEquals(0, entities.size());
	}

	@Test
	public void testCreate() throws Exception {
		E entity = getInjector().getInstance(getEntity());
		beforeCreate(entity);
		E result = service.create(entity);
		assertNotNull(result);
		service.delete(entity);
	}

	@Test
	public void testRead() throws Exception {
		E entity = getInjector().getInstance(getEntity());
		beforeCreate(entity);
		service.create(entity);
		@SuppressWarnings("unchecked")
		KEYTYPE key = (KEYTYPE) entity.getKey();
		E entityRead = service.read(key);
		assertNotNull(entityRead);
		assertEquals(key, entityRead.getKey());
		service.delete(entity);
	}

	@Test
	public void testUpdate() throws Exception {
		E entity = getInjector().getInstance(getEntity());
		beforeCreate(entity);
		service.create(entity);
		service.update(entity);
		service.delete(entity);
	}

	@Test
	public void testDelete() throws Exception {
		E entity = getInjector().getInstance(getEntity());
		beforeCreate(entity);
		service.create(entity);
		@SuppressWarnings("unchecked")
		KEYTYPE key = (KEYTYPE) entity.getKey();
		E find = service.read(key);
		service.delete(find);
		find = service.read(key);
		assertNull(find);
	}
	
}
