package com.revature;

import com.revature.controllers.LoginController;
import com.revature.controllers.ReimbursementController;
import com.revature.models.TableData;

import io.javalin.Javalin;

public class Main {

	public static void main(String[] args) {
		
		//instantiate controller objects
		ReimbursementController rc = new ReimbursementController();
		LoginController lc = new LoginController(); 
		
		//vvv used to populate the DB with test data
		//TableData popDb = new TableData();
		//popDb.populateDB();
		
		//starts a javalin server on port 8090 with cors enabled
		Javalin app = Javalin.create(
  			config -> {
					config.enableCorsForAllOrigins();
				}
				).start(8090);
		
		//front controller logic
		app.post("/login", lc.loginHandler);
		app.post("/reimbursement/add", rc.addReimHandler);
		
		app.patch("/reimbursement/update", rc.updateReimHandler);
		
		app.get("/reimbursement", rc.getAllReimsHandler);
		app.get("/reimbursement/user/:user_id", rc.getReimsByUserIdHandler);
		app.get("/reimbursement/status/:status_id", rc.getReimsByStatusIdHandler);	
		
	}

}
