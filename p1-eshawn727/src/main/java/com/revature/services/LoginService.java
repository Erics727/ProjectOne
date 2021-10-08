package com.revature.services;

import com.revature.daos.UsersDao;
import com.revature.models.Users;

public class LoginService {
	
	UsersDao uDao = new UsersDao();	

	public boolean login(String username, String password) {
		
		return uDao.getUserLogin(username, password);
		
	}

	

}
