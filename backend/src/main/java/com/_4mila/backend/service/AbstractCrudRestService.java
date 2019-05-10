package com._4mila.backend.service;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;

import java.lang.reflect.Field;

import javax.persistence.ManyToMany;
import javax.persistence.PersistenceException;
import javax.persistence.RollbackException;

import org.hibernate.exception.ConstraintViolationException;

import com._4mila.backend.server.json.JsonHelper;
import com._4mila.backend.server.json.ReflectionUtility;
import com._4mila.backend.service.exception.BackendValidationException;
import com.google.common.primitives.Longs;
import com.google.inject.Inject;
import com.google.inject.Injector;

public abstract class AbstractCrudRestService<ENTITY, KEYTYPE, DATABASESERIVCE> extends AbstractRestService<AbstractCrudDatabaseService<ENTITY, KEYTYPE>> {

	@Inject
	JsonHelper jsonHelper;

	private Class<ENTITY> entityClass;
	private String jsonEntityName;

	@SuppressWarnings("unchecked")
	public AbstractCrudRestService(Injector injector, Class<DATABASESERIVCE> databaseServiceClass) {
		super(injector, (Class<AbstractCrudDatabaseService<ENTITY, KEYTYPE>>) databaseServiceClass);
	}

	@Override
	public final void init() {
		entityClass = getDatabaseService().getEntityClass();
		jsonEntityName = Character.toLowerCase(entityClass.getSimpleName().charAt(0)) + entityClass.getSimpleName().substring(1);

		initList();
		initGet();
		initPost();
		initPut();
		initDelete();
	}

	protected void initList() {
		get("services/" + jsonEntityName, (req, res) -> {
			return getDatabaseService().createPathList(getDatabaseService().list());
		}, getJsonTransformer());
	}

	protected void initGet() {
		get("services/" + jsonEntityName + "/:key", (req, res) -> {
			KEYTYPE key = null;
			if (req.params("key") != null && !req.params("key").equals("null")) {
				key = parseKey(req.params("key"));
				return getDatabaseService().read(key);
			}
			return getDatabaseService().prepare();
		}, getJsonTransformer());
	}

	protected void initPost() {
		post("services/" + jsonEntityName, (req, res) -> {
			ENTITY entity = fromJson(req.body(), entityClass);
			ENTITY result = null;
			try {
				result = getDatabaseService().create(entity);
			} catch (RollbackException e) {
				if (e.getCause() instanceof PersistenceException && e.getCause().getCause() instanceof ConstraintViolationException) {
					throw new BackendValidationException("DuplicateDataError");
				} else {
					throw e;
				}
			}
			return result;
		}, getJsonTransformer());
	}

	protected void initPut() {
		put("services/" + jsonEntityName + "/:key", (req, res) -> {
			KEYTYPE key = parseKey(req.params("key"));
			ENTITY entity = fromJson(req.body(), entityClass);
			ENTITY original = null;
			for (Field field : ReflectionUtility.getAllFields(entity.getClass())) {
				if (field.getAnnotation(ManyToMany.class) != null) {
					if (original == null) {
						original = getDatabaseService().read(key);
					}
					field.setAccessible(true);
					field.set(entity, field.get(original));
				}
			}
			entityClass.getMethod("setKey", key.getClass()).invoke(entity, key);
			return getDatabaseService().update(entity);
		}, getJsonTransformer());
	}

	protected void initDelete() {
		delete("services/" + jsonEntityName + "/:key", (req, res) -> {
			KEYTYPE key = parseKey(req.params("key"));
			ENTITY entity = getDatabaseService().read(key);
			entityClass.getMethod("setKey", key.getClass()).invoke(entity, key);
			boolean status = false;
			try {
				status = getDatabaseService().delete(entity);
			} catch (RollbackException e) {
				if (e.getCause() instanceof PersistenceException && e.getCause().getCause() instanceof ConstraintViolationException) {
					throw new BackendValidationException("DataReferencedError");
				} else {
					throw e;
				}
			}
			return status;
		}, getJsonTransformer());
	}

	@SuppressWarnings("unchecked")
	public DATABASESERIVCE getCrudDatabaseService() {
		return (DATABASESERIVCE) super.getDatabaseService();
	}

	@SuppressWarnings("unchecked")
	private KEYTYPE parseKey(String keyString) {
		Object key = Longs.tryParse(keyString);
		if (key == null) {
			return (KEYTYPE) keyString;
		}
		return (KEYTYPE) key;
	}

}