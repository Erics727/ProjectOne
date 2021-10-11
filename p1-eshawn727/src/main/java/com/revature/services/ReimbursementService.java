package com.revature.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.ReimbursementDao;
import com.revature.models.Reimbursement;


public class ReimbursementService {
	
	//instantiate a ReimbursementDao
	ReimbursementDao rDao = new ReimbursementDao();
	Logger log = LogManager.getLogger(ReimbursementService.class);
	
	//method will return all reimbursement data from the Dao to the Controller
	public List<Reimbursement> getAllReims() {
		
		log.info("USER RETRIEVED ALL REIMBURSEMENTS");
		return rDao.getAllReims();
		
	}
	
	//method will return all reimbursement data by user id from the Dao to the Controller
	public List<Reimbursement> getReimsByUserId(int user_id) {
		
		log.info("USER RETRIEVED ALL REIMBURSEMENTS FOR USER " + user_id);
		return rDao.getReimsByUserId(user_id);
		
	}
	
	//method will return all reimbursement data by status id from the Dao to the Controller
	public List<Reimbursement> getReimsByStatusId(int status_id) {
		
		log.info("USER RETRIEVED ALL REIMBURSEMENTS WITH STATUS " + status_id);
		return rDao.getReimsByStatusId(status_id);
		
	}
	
	//method updates a reimbursement with a given id to the givin status
	public void updateReimStatus(int reim_id, int reim_status) {
		
		log.info("USER UPDATED REIMBURSEMENT REIM_ID: " + reim_id);
		rDao.updateReimStatus(reim_id, reim_status);
		
	}
	
	//method adds new reimbursements to the database
	public void addReim(Reimbursement reim) {
		
		log.info("USER " + reim.getReim_author().getUser_id() + " ADDED NEW REIMBURSEMENT");
		rDao.addReim(reim);
		
	}
}
