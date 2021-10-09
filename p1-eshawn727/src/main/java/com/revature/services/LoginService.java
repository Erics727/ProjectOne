package com.revature.services;

import com.revature.daos.UsersDao;
import com.revature.models.Users;

public class LoginService {
	
	UsersDao uDao = new UsersDao();	

	public Users login(String username, String password) {// change to return user not boolean
		//if this vvv works, call dao method to get user by uname/pass and return that user
		if (uDao.getUserLogin(username, password)) {
			return uDao.getUserByLogin(username);
		}
		
		return null;
		
	}

	

}
