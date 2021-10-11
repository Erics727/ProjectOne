package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.models.LoginDTO;
import com.revature.models.Users;
import com.revature.services.LoginService;

import io.javalin.http.Handler;

public class LoginController {
	
	LoginService ls = new LoginService();

	//checks the database for valid user credentials and returns the Users object
	public Handler loginHandler = (ctx) -> {
		
		try {
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
			
		} catch (NullPointerException e) {
			System.out.println("Null pointer exception in loginHandler");
			e.printStackTrace();
			ctx.status(404);
			
		} catch (NumberFormatException e) {
			System.out.println("Number format exception in loginHandler");
			e.printStackTrace();
			ctx.status(404);
			
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Index out of bounds in loginHandler");
			e.printStackTrace();
			ctx.status(404);
			
		} catch (Exception e) {
			System.out.println("Something went wrong with loginHandler!");
			e.printStackTrace();
			ctx.status(500);
		}	
		
	};
	
	
}
