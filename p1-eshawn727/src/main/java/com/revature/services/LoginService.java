package com.revature.services;

import com.revature.daos.UsersDao;

public class LoginService {
	
	UsersDao uDao = new UsersDao();

	//hardcoding username/password - I don't want to create a whole users table/DAO ;P
	
	//Typically you'll want to validate user/pass against some user/pass in your database
		//So in your P1 you'dd be sending the data from the LoginDTO into the dao
		//And most likely doing some dao method that uses those values to check for matching values in the DB
		//where clause?
	
	public boolean login(String username, String password) {
		
		if(username.equals("eric727") && password.equals("password")) {
			return true;
		}
		
		return false;
		
	}
	
	/*
	public boolean login(String username, String password) {
		
		return uDao.getUserLogin(username, password);
		
	}
	*/
}
