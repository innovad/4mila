package com._4mila.backend.service.user.permission;

import com._4mila.backend.model.user.permission.PermissionRole;
import com._4mila.backend.service.AbstractCrudDatabaseService;
import com._4mila.backend.service.PathListEntry;

public class PermissionRoleDatabaseService extends AbstractCrudDatabaseService<PermissionRole, Long> {

	@Override
	public Class<PermissionRole> getEntityClass() {
		return PermissionRole.class;
	}
	
	@Override
	public void createPathListEntry(PermissionRole entity, PathListEntry<Long> entry) {
		entry.setKey(entity.getKey(), getKeyName());
		entry.setName(entity.getName());
		if (entity.getPermissionFunctions().size() == 1) {
			entry.getDetails().add(entity.getPermissionFunctions().size() + " Function");
		} else {
			entry.getDetails().add(entity.getPermissionFunctions().size() + " Functions");
		}
	}

}