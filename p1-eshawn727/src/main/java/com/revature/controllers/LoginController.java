package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.models.LoginDTO;
import com.revature.models.Users;
import com.revature.services.LoginService;

import io.javalin.http.Handler;

public class LoginController {
	
	LoginService ls = new LoginService();

	
	public Handler loginHandler = (ctx) -> {
		
		String body = ctx.body(); 
		
		Gson gson = new Gson();
		
		LoginDTO LDTO = gson.fromJson(body, LoginDTO.class); 
		
		Users user = ls.login(LDTO.getUsername(), LDTO.getPassword());
		
		if(user != null) { 
			
			String JSONUser = gson.toJson(user);
			
			ctx.req.getSession();
			
			ctx.status(200);
			
			ctx.result(JSONUser);
			
		} else {
			
			ctx.status(401);
			
			ctx.result("Login Failed! :(");
			
		}	
		
	};
	
	
}
