package com._4mila.backend.service.user.permission;

import com._4mila.backend.model.user.permission.PermissionFunction;
import com._4mila.backend.service.AbstractCrudDatabaseService;
import com._4mila.backend.service.PathListEntry;

public class PermissionFunctionDatabaseService extends AbstractCrudDatabaseService<PermissionFunction, String> {

	@Override
	public Class<PermissionFunction> getEntityClass() {
		return PermissionFunction.class;
	}

	@Override
	public void createPathListEntry(PermissionFunction entity, PathListEntry<String> entry) {
		entry.setKey(entity.getKey(), getKeyName());
		entry.setName(entity.getName());
	}

}