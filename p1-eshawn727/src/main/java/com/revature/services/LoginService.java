package com.revature.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.UsersDao;
import com.revature.models.Users;

public class LoginService {
	
	UsersDao uDao = new UsersDao();	
	Logger log = LogManager.getLogger(LoginService.class);
	
	//checks DB for a valid user
	public Users login(String username, String password) {
		
		//if user is valid, return the Users object
		if (uDao.getUserLogin(username, password)) {
			return uDao.getUserByLogin(username);
		}
		
		log.warn("FAILED LOGIN ATTEMPT");
		return null;	
	}
}
