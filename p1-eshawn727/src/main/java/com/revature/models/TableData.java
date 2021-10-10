package com.revature.models;

import java.sql.Timestamp;

import com.revature.daos.ReimbursementDao;
import com.revature.daos.ReimbursementStatusDao;
import com.revature.daos.ReimbursementTypeDao;
import com.revature.daos.UserRolesDao;
import com.revature.daos.UsersDao;

public class TableData {
	
	private ReimbursementDao reimDao = new ReimbursementDao();
	private ReimbursementTypeDao typeDao = new ReimbursementTypeDao();
	private ReimbursementStatusDao statusDao = new ReimbursementStatusDao();
	private UsersDao userDao = new UsersDao();
	private UserRolesDao roleDao = new UserRolesDao();
	
	
	
	public TableData() {
		super();
		
	}
	

	public void populateDB() {
		
		UserRoles manager = new UserRoles("Manager");
		UserRoles salesRep = new UserRoles("Sales Representative");
		UserRoles developer = new UserRoles("Software Developer");
		roleDao.addUserRole(manager);
		roleDao.addUserRole(salesRep);
		roleDao.addUserRole(developer);
		
		
		ReimbursementType travel = new ReimbursementType("Travel"); 
		ReimbursementType lodging = new ReimbursementType("Lodging");
		ReimbursementType food = new ReimbursementType("Food");
		ReimbursementType other = new ReimbursementType("Other");
		typeDao.addReimType(lodging);
		typeDao.addReimType(travel);
		typeDao.addReimType(food);
		typeDao.addReimType(other);
		
		ReimbursementStatus pending = new ReimbursementStatus("Pending");
		ReimbursementStatus approved = new ReimbursementStatus("Approved");
		ReimbursementStatus denied = new ReimbursementStatus("Denied");
		statusDao.addStatus(pending);
		statusDao.addStatus(approved);
		statusDao.addStatus(denied);
		
		Users user1 = new Users("eric727", "password", "Ralph", "Hancock", "ralph@fake.com", developer);
		Users user2 = new Users("jamie3645", "pword", "Jamie", "Thompson", "jamie@fake.com", salesRep);
		Users user3 = new Users("jennie123", "pass", "Jennie", "Jones", "jennie@fake.com", developer);
		Users user4 = new Users("tom2", "letmein", "Tom", "Williams", "tom@fake.com", salesRep);
		Users user5 = new Users("Amy5", "allowme", "Amy", "Shawn", "amy@fake.com", manager);
		userDao.addUser(user1);
		userDao.addUser(user2);
		userDao.addUser(user3);
		userDao.addUser(user4);
		userDao.addUser(user5);
		
		
		Timestamp ts1 = new Timestamp(System.currentTimeMillis());
		
		Reimbursement reim1 = new Reimbursement(150.25, ts1 ,"Hotel for convention", user1, pending, lodging);
		Reimbursement reim2 = new Reimbursement(250.56, ts1, "Lunch with clients", user2, denied, food);
		Reimbursement reim3 = new Reimbursement(50.72, ts1, "Gas", user4, approved, other);
		Reimbursement reim4 = new Reimbursement(2550.25, ts1, "Dinner with mom", user2, pending, food);
		Reimbursement reim5 = new Reimbursement(136.00, ts1, "Bus Fair", user1, approved, travel);
		Reimbursement reim6 = new Reimbursement(350.25, ts1, "Ipad for my kids", user3, pending, other);
		Reimbursement reim7 = new Reimbursement(45289.99, ts1, "Company car", user4, pending, travel);
		Reimbursement reim8 = new Reimbursement(350.25, ts1, "Plane tickets", user2, pending, food);
		Reimbursement reim9 = new Reimbursement(236.18, ts1, "Hotel for client", user1, approved, lodging);
		Reimbursement reim10 = new Reimbursement(56.32, ts1, "Subway tokens", user3, pending, travel);
					
		reimDao.addReim(reim1);
		reimDao.addReim(reim2);
		reimDao.addReim(reim3);
		reimDao.addReim(reim4);
		reimDao.addReim(reim5);
		reimDao.addReim(reim6);
		reimDao.addReim(reim7);
		reimDao.addReim(reim8);
		reimDao.addReim(reim9);
		reimDao.addReim(reim10);
				
	}	
}
