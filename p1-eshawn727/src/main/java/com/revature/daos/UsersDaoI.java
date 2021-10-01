package com.revature.daos;

import java.util.List;

import com.revature.models.Users;

public interface UsersDaoI {
	
	public void addUser(Users user);
	
	public List<Users> getAllUsers();
}
