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
	
	//method will return all reimbursement data by status from the Dao to the Controller
	public List<Reimbursement> getReimsByStatus(ReimbursementStatus status) {
		
		return rDao.getReimsByStatus(status);
		
	}
	
	//method will return all reimbursement data by user id from the Dao to the Controller
	public List<Reimbursement> getReimsById(int id) {
		
		return rDao.getReimsByUserId(id);
		
	}
	
	//method will return all reimbursement data by status id from the Dao to the Controller
	public List<Reimbursement> getReimsByStatusId(int id) {
		
		return rDao.getReimsByStatusId(id);
		
	}
	
	public void addReim(Reimbursement reim) {
		
		rDao.addReim(reim);
		
	}

}
