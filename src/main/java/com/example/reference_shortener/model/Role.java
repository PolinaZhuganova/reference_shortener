package com.example.reference_shortener.model;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Класс Role
 */
public enum Role {
	USER(Set.of(Permission.USER_GENERATES)),
	ADMIN(Set.of(Permission.USER_GENERATES, Permission.USER_MODIFIES));

	private final Set<Permission> permissions;

	Role (Set<Permission> permissions){
		this.permissions = permissions;
	}
	public Set <Permission> getPermissions(){
		return permissions;
	}

	public Set<SimpleGrantedAuthority> getAuthorities(){
		return getPermissions().stream()
			.map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
			.collect(Collectors.toSet());
	}
}