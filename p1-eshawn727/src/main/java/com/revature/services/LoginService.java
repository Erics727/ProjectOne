package com.revature.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.UsersDao;
import com.revature.models.Users;

public class LoginService {
	
	UsersDao uDao = new UsersDao();	
	Logger log = LogManager.getLogger(LoginService.class);

	public Users login(String username, String password) {
		
		if (uDao.getUserLogin(username, password)) {
			return uDao.getUserByLogin(username);
		}
		
		log.warn("FAILED LOGIN ATTEMPT");
		return null;	
	}
}
