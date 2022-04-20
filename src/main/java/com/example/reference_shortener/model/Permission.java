package com.example.reference_shortener.model;

/**
 * Класс Permission
 */
public enum Permission {
	USER_GENERATES("user:generates"),
	USER_MODIFIES("user:modifies");

	private final String permission;
	Permission(String permission){
		this.permission = permission;
	}
	public String getPermission(){
		return permission;
	}
}