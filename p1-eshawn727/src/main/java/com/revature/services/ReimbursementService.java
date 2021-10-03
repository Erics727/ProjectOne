package com.revature.services;

import java.util.List;

import com.revature.daos.ReimbursementDao;
import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.models.Users;

public class ReimbursementService {
	
	//instantiate a ReimbursementDao
	ReimbursementDao rDao = new ReimbursementDao();
	
	//method will return all reimbursement data from the Dao to the Controller
	public List<Reimbursement> getAllReims() {
		
		return rDao.getAllReims();
		
	}
	
	//method will return all reimbursement data by user id from the Dao to the Controller
	public List<Reimbursement> getReimsByUserId(int user_id) {
		
		return rDao.getReimsByUserId(user_id);
		
	}
	
	//method will return all reimbursement data by status id from the Dao to the Controller
	public List<Reimbursement> getReimsByStatusId(int status_id) {
		
		return rDao.getReimsByStatusId(status_id);
		
	}
	
	public void addReim(Reimbursement reim) {
		
		rDao.addReim(reim);
		
	}

}
