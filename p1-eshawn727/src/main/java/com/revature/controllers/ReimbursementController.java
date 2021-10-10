package com.revature.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementDTO;
import com.revature.models.UpdateDTO;
import com.revature.services.ReimbursementService;

import io.javalin.http.Handler;

public class ReimbursementController {
	
	ReimbursementService rs = new ReimbursementService();
	
	
	public Handler getAllReimsHandler = (ctx) -> {
		
		//if a session exists
		//if(ctx.req.getSession(false) != null) {
			
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
			
		//} else {
			
			//else send a forbidden code
		//	ctx.status(403);
		//}
		
	};
	
	
	public Handler getReimsByUserIdHandler = (ctx) -> {
		
		//if a session exists
		//if(ctx.req.getSession(false) != null) {
		
			//read in an int representing user id from the path parameters
			int user_id = Integer.parseInt(ctx.pathParam("user_id"));
			
			//create an array with reim data
			List<Reimbursement> reimsByUserId = rs.getReimsByUserId(user_id);
			
			//instantiate a Gson object to convert between JSON and POJO
			Gson gson = new Gson();
			
			//convert the java object to a JSON string
			String JSONReims = gson.toJson(reimsByUserId);
			
			//return reimbursement data
			ctx.result(JSONReims);
			
			//send a 200 code(success)
			ctx.status(200);
			
		//} else {
			
			//else send a forbidden code
		//	ctx.status(403);
		//}
		
	};
	
	
	public Handler getReimsByStatusIdHandler = (ctx) -> {
		
		//if a session exists
		//if(ctx.req.getSession(false) != null) {
		
			//read in an int representing user id from the path parameters
			int status_id = Integer.parseInt(ctx.pathParam("status_id"));
			
			//create an array with reim data
			List<Reimbursement> reimsByStatusId = rs.getReimsByStatusId(status_id);
			
			//instantiate a Gson object to convert between JSON and POJO
			Gson gson = new Gson();
			
			//convert the java object to a JSON string
			String JSONReims = gson.toJson(reimsByStatusId);
			
			//return reimbursement data
			ctx.result(JSONReims);
			
			//send a 200 code(success)
			ctx.status(200);
			
		//} else {
			
			//else send a forbidden code
		//	ctx.status(403);
		//}
		
	};
	
	
	public Handler updateReimHandler = (ctx) -> {
		
		//if a session exists
		//if(ctx.req.getSession(false) != null) {
		
			String body = ctx.body(); //turn the body (data) of the POST request into a Java String
		
			Gson gson = new Gson();
		
			UpdateDTO UDTO = gson.fromJson(body, UpdateDTO.class); 
		
			rs.updateReimStatus(UDTO.getReim_id(), UDTO.getStatus_id());
		
			ctx.status(201);
		
		//} else {
			
			//else send a forbidden code
		//	ctx.status(403);
		//}
		
		
	};
	
	
	public Handler addReimHandler = (ctx) -> {
		
		//if a session exists
		//if(ctx.req.getSession(false) != null) {
		
			String body = ctx.body();
		
			Gson gson = new Gson();
		
			ReimbursementDTO RDTO = gson.fromJson(body, ReimbursementDTO.class);
		
			Reimbursement newReim = new Reimbursement(RDTO.getAmount(), RDTO.getDescription(), RDTO.getUser_id(), RDTO.getReim_type());
		
			rs.addReim(newReim);
		
			ctx.status(201);
			
		//} else {
			
			//else send a forbidden code
		//	ctx.status(403);
		//}
	};

}
