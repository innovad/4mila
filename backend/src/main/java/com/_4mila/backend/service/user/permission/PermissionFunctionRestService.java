package com._4mila.backend.service.user.permission;

import static spark.Spark.get;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import com._4mila.backend.model.user.permission.PermissionFunction;
import com._4mila.backend.model.user.permission.PermissionFunctionEnum;
import com._4mila.backend.model.user.permission.PermissionRole;
import com._4mila.backend.service.AbstractCrudRestService;
import com._4mila.backend.service.ColorUtility;
import com._4mila.backend.service.PathListEntry;
import com._4mila.backend.service.exception.BackendValidationException;
import com._4mila.backend.service.user.UserDatabaseService;
import com.google.common.primitives.Longs;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class PermissionFunctionRestService extends AbstractCrudRestService<PermissionFunction, String, PermissionFunctionDatabaseService> {

	@Inject
	PermissionRoleDatabaseService permissionRoleDatabaseService;

	@Inject
	UserDatabaseService userDatabaseService;

	@Inject
	public PermissionFunctionRestService(Injector injector) {
		super(injector, PermissionFunctionDatabaseService.class);
	}

	@Override
	protected void initGet() {
		super.initGet();

		get("services/permissionRole/:permissionRoleKey/permissionFunction", (req, res) -> {
			Long permissionRoleKey = Longs.tryParse(req.params("permissionRoleKey"));
			PermissionRole role = permissionRoleDatabaseService.read(permissionRoleKey);

			TreeSet<PermissionFunction> set = new TreeSet<>(getCrudDatabaseService().list());
			List<PathListEntry<String>> resultList = new ArrayList<>();
			for (PermissionFunction function : set) {
				PathListEntry<String> result = new PathListEntry<>();
				getCrudDatabaseService().createPathListEntry(function, result);
				if (role.getPermissionFunctions().contains(function)) {
					result.setColor(ColorUtility.selected);
				} else {
					result.setColor(ColorUtility.notSelected);
				}
				result.setUrl("/permissionRole/:permissionRoleKey/permissionFunction/:permissionFunctionKey");
				resultList.add(result);
			}

			return resultList;
		}, getJsonTransformer());

		get("services/permissionRole/:permissionRoleKey/permissionFunction/:permissionFunctionKey", (req, res) -> {
			Long permissionRoleKey = Longs.tryParse(req.params("permissionRoleKey"));
			String permissionFunctionKey = req.params("permissionFunctionKey");
			PermissionRole role = permissionRoleDatabaseService.read(permissionRoleKey);
			PermissionFunction function = getCrudDatabaseService().read(permissionFunctionKey);

			if (role.getPermissionFunctions().contains(function)) {
				role.getPermissionFunctions().remove(function);
			} else {
				role.getPermissionFunctions().add(function);
			}
			permissionRoleDatabaseService.update(role);

			return true;
		}, getJsonTransformer());

		get("services/permissionFunction/check/:entity/:crudOperation", (req, res) -> {
			// parse ! to check if permission must be required/absent
			String operation = req.params("crudOperation");
			boolean permissionRequired = !operation.startsWith("!");
			operation = operation.replace("!", "");
			
			String permissionFunctionKey = (operation + req.params("entity")).toLowerCase();
			boolean legalPermission = false;
			for (PermissionFunctionEnum p : PermissionFunctionEnum.values()) {
				if (p.name().equalsIgnoreCase(permissionFunctionKey)) {
					legalPermission = true;
					break;
				}
			}
			if (!legalPermission) {
				throw new RuntimeException("Unknown Permission " + permissionFunctionKey);
			}
			boolean hasPermission = userDatabaseService.checkPermissionFunction(userDatabaseService.getCurrentUser(req), permissionFunctionKey);
			boolean checkResult = (permissionRequired && hasPermission) || (!permissionRequired && !hasPermission);
			return new PermissionCheckView(checkResult);
		}, getJsonTransformer());
		
		get("services/permissionFunction/check/noAccess", (req, res) -> {
			// dummy service for restricted buttons
			throw new BackendValidationException("NoPermissionError");
		}, getJsonTransformer());
		
		get("services/permissionFunction/parameterCheck/:key1/:key2", (req, res) -> {
			return new PermissionCheckView(Longs.tryParse(req.params("key1")) != null && Longs.tryParse(req.params("key2")) != null);
		}, getJsonTransformer());
	}
	
	@SuppressWarnings("unused")
	private class PermissionCheckView {

		private boolean permission;

		public PermissionCheckView(boolean permission) {
			this.permission = permission;
		}

	}

}