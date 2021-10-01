package com.revature.daos;

import java.util.List;

import com.revature.models.UserRoles;

public interface UserRolesDaoI {
	
	public void addUserRole(UserRoles role);
	
	public List<UserRoles> getAllUserRoles();

}
