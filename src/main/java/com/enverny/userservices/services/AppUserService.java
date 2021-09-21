package com.enverny.userservices.services;

import java.util.List;

import com.enverny.userservices.entities.AppUser;
import com.enverny.userservices.entities.Role;

public interface AppUserService {
	AppUser saveUser (AppUser user);
	Role saveRole(Role role);
	void addRoleToUser(String username, String roleName);
	AppUser getUser(String username);
	List<AppUser> getUsers();
}
