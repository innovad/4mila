package com._4mila.backend.service.user.permission;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.put;

import com._4mila.backend.model.user.User;
import com._4mila.backend.model.user.permission.PermissionRole;
import com._4mila.backend.service.AbstractCrudRestService;
import com._4mila.backend.service.user.UserDatabaseService;
import com.google.common.primitives.Longs;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class PermissionRoleRestService extends AbstractCrudRestService<PermissionRole, Long, PermissionRoleDatabaseService> {

	@Inject
	UserDatabaseService userDatabaseService;

	@Inject
	public PermissionRoleRestService(Injector injector) {
		super(injector, PermissionRoleDatabaseService.class);
	}

	@Override
	protected void initGet() {
		super.initGet();

		get("services/user/:userKey/permissionRole", (req, res) -> {
			Long userKey = Longs.tryParse(req.params("userKey"));
			User user = userDatabaseService.read(userKey);
			return getCrudDatabaseService().createPathList(user.getPermissionRoles());
		}, getJsonTransformer());
		
		get("services/user/:userKey/permissionRole/:permissionRoleKey", (req, res) -> {
			Long userKey = Longs.tryParse(req.params("userKey"));
			Long permissionRoleKey = Longs.tryParse(req.params("permissionRoleKey"));
			UserRolePermissionView view = new UserRolePermissionView();
			view.userKey = userKey;
			view.permissionRoleKey = permissionRoleKey;
			return view;
		}, getJsonTransformer());
	}

	@Override
	protected void initPut() {
		super.initPut();

		put("services/user/:userKey/permissionRole", (req, res) -> {
			UserRolePermissionView userRolePermissionView = fromJson(req.body(), UserRolePermissionView.class);
			User user = userDatabaseService.read(userRolePermissionView.userKey);
			PermissionRole role = getCrudDatabaseService().read(userRolePermissionView.permissionRoleKey);
			user.getPermissionRoles().add(role);
			return userDatabaseService.update(user);
		}, getJsonTransformer());
		
		put("services/user/:userKey/permissionRole/:permissionRoleKey", (req, res) -> {
			return true;
		}, getJsonTransformer());
	}
	
	@Override
	protected void initDelete() {
		super.initDelete();

		delete("services/user/:userKey/permissionRole/:permissionRoleKey", (req, res) -> {
			User user = userDatabaseService.read(Long.valueOf(req.params("userKey")));
			PermissionRole role = getCrudDatabaseService().read(Long.valueOf(req.params("permissionRoleKey")));
			user.getPermissionRoles().remove(role);
			return userDatabaseService.update(user);
		}, getJsonTransformer());
	}
	
	private class UserRolePermissionView {

		private Long userKey;
		private Long permissionRoleKey;

	}

}