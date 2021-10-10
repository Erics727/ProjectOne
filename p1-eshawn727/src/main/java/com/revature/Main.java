package com.revature;

import com.revature.controllers.LoginController;
import com.revature.controllers.ReimbursementController;

import io.javalin.Javalin;

public class Main {

	public static void main(String[] args) {
		
		ReimbursementController rc = new ReimbursementController();
		LoginController lc = new LoginController(); 
		
		//TableData popDb = new TableData();
		//popDb.populateDB();
		
		Javalin app = Javalin.create(
  			config -> {
					config.enableCorsForAllOrigins();
				}
				).start(8090);
		
		app.post("/login", lc.loginHandler);
		app.post("/reimbursement/add", rc.addReimHandler);
		
		app.patch("/reimbursement/update", rc.updateReimHandler);
		
		app.get("/reimbursement", rc.getAllReimsHandler);
		app.get("/reimbursement/user/:user_id", rc.getReimsByUserIdHandler);
		app.get("/reimbursement/status/:status_id", rc.getReimsByStatusIdHandler);	
		
	}

}
