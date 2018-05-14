package com._4mila.backend.service.exception;

public class PermissionView {

	public PermissionView(boolean permission) {
		this.permission = permission;
	}

	private boolean permission = false;
	
	public boolean getPermission() {
		return permission;
	}
	
}

