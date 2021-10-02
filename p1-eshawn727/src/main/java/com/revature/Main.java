package com.revature;

import java.sql.Timestamp;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.controllers.LoginController;
import com.revature.controllers.ReimbursementController;
import com.revature.daos.ReimbursementDao;
import com.revature.daos.ReimbursementStatusDao;
import com.revature.daos.ReimbursementTypeDao;
import com.revature.daos.UserRolesDao;
import com.revature.daos.UsersDao;
import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.models.ReimbursementType;
import com.revature.models.TableData;
import com.revature.models.UserRoles;
import com.revature.models.Users;

import io.javalin.Javalin;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		try(Session ses = HibernateUtil.getSession()){
			System.out.println("Hibernate Connection Success");
			HibernateUtil.closeSession();
		} catch(HibernateException e) {
			e.printStackTrace();
			System.out.println("Hibernate Failed Connection");
		}
		*/
		/*
		//create dao objects
		ReimbursementDao reimDao = new ReimbursementDao();
		ReimbursementTypeDao typeDao = new ReimbursementTypeDao();
		ReimbursementStatusDao statusDao = new ReimbursementStatusDao();
		UsersDao userDao = new UsersDao();
		UserRolesDao roleDao = new UserRolesDao();
		*/
		
		Logger log = LogManager.getLogger(Main.class);
		
		
		TableData popDb = new TableData();
		popDb.populateDB();
		
	
		//List<Reimbursement> reimList = reimDao.getAllReims(); //functional
		//List<Reimbursement> reimList = reimDao.getReimsByStatusId(1); // functional?? pass int
		//List<Reimbursement> reimList = reimDao.getReimsById(user1); //functional?? int??
		//for(Reimbursement r: reimList) {
		//	System.out.println(r);
		//}
		
		//reim1.setReim_status(status2);
		//reimDao.updateReimStatus(reim1,status2);  //pass ints for ids to update????
		//reim2.setReim_status(status1);
		//reimDao.updateReimStatus(reim2, status1);
		
		/*
		for(Reimbursement r: reimList) {
			System.out.println(r);
		}
		*/
		
		
		/*
		System.out.println();
		List<Users> usersList = userDao.getAllUsers();
		for(Users u: usersList) {
			System.out.println(u);
		}
		
		List<UserRoles> rolesList = roleDao.getAllUserRoles();
		for(UserRoles r: rolesList) {
			System.out.println(r);
		}
		*/
		
		//log.info("log test");
		
		
		ReimbursementController rc = new ReimbursementController();
		LoginController lc = new LoginController(); 
		
		Javalin app = Javalin.create().start(8090);
		
		app.post("/login", lc.loginHandler);
		
		app.get("/reimbursement", rc.getAllReimsHandler);
		
	}

}
