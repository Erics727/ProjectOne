package com.revature.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.services.ReimbursementService;

import io.javalin.http.Handler;

public class ReimbursementController {
	
	ReimbursementService rs = new ReimbursementService();
	
	
	public Handler getAllReimsHandler = (ctx) -> {
		
		//if a session exists
		if(ctx.req.getSession(false) != null) {
			
			//create an array with reim data
			List<Reimbursement> allReims = rs.getAllReims();
			
			//instantiate a Gson object to convert between JSON and POJO
			Gson gson = new Gson();
			
			//convert the java object to a JSON string
			String JSONReims = gson.toJson(allReims);
			
			//return reimbursement data
			ctx.result(JSONReims);
			
			//send a 200 code(success)
			ctx.status(200);
			
		} else {
			
			//else send a forbidden code
			ctx.status(403);
		}
		
	};
	
	
	public Handler addReimHandler = (ctx) -> {
		
		String body = ctx.body();
		
		Gson gson = new Gson();
		
		Reimbursement reim  = gson.fromJson(body, Reimbursement.class);
		
		rs.addReim(reim);
		
		ctx.status(201);
	};

}
