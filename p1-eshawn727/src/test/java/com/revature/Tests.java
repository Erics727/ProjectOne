package com.revature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
//import vs import static? In this case, we need to import the static members of the Assertions class
//our assert methods won't be visible without the "static"

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.revature.daos.ReimbursementDao;
import com.revature.daos.UsersDao;
import com.revature.models.Reimbursement;
import com.revature.models.Users;
import com.revature.services.LoginService;
import com.revature.services.ReimbursementService;

public class Tests {
	
	ReimbursementDao rDao = new ReimbursementDao();
	UsersDao uDao = new UsersDao();
	ReimbursementService rs = new ReimbursementService();
	LoginService ls = new LoginService();
		
	
	@Test
	public void testGetAllReims() {
		
		List<Reimbursement> reims = rDao.getAllReims();
		List<Reimbursement> reims2 = rs.getAllReims();
		
		assertEquals(reims, reims2);
		
	}
	
	@Test
	public void testGetReimsByUserId() {
		
		List<Reimbursement> reims = rDao.getReimsByUserId(1);
		List<Reimbursement> reims2 = rs.getReimsByUserId(1);
		
		assertEquals(reims, reims2);
		
	}
	
	@Test
	public void testGetReimsByStatusId() {
		
		List<Reimbursement> reims = rDao.getReimsByStatusId(2);
		List<Reimbursement> reims2 = rs.getReimsByStatusId(2);
		
		assertEquals(reims, reims2);
		
	}
	
	@Test
	public void testUpdateReimStatus() {
		
		rs.updateReimStatus(1, 2);
		Reimbursement reim = rDao.getReimsById(1);
		
		assertEquals(reim.getReim_status().getStatus_id(), 2);
		
	}
	
	@Test
	public void testLogin() {
		
		Users user = uDao.getUserByLogin("eric727");
		Users user2 = ls.login("eric727", "password");
		
		assertEquals(user, user2);
		
	}
	
	@Test
	public void testGetReimsByUserId2() {
		
		List<Reimbursement> reims = rDao.getReimsByUserId(2);
		List<Reimbursement> reims2 = rs.getReimsByUserId(2);
		
		assertEquals(reims, reims2);
		
	}
	
	@Test
	public void testGetReimsByStatusId2() {
		
		List<Reimbursement> reims = rDao.getReimsByStatusId(3);
		List<Reimbursement> reims2 = rs.getReimsByStatusId(3);
		
		assertEquals(reims, reims2);
		
	}
	
	@Test
	public void testUpdateReimStatus2() {
		
		rs.updateReimStatus(2, 3);
		Reimbursement reim = rDao.getReimsById(2);
		
		assertEquals(reim.getReim_status().getStatus_id(), 3);
		
	}
	
	@Test
	public void testLogin2() {
		
		Users user = uDao.getUserByLogin("Amy5");
		Users user2 = ls.login("Amy5", "allowme");
		
		assertEquals(user, user2);
		
	}
}
