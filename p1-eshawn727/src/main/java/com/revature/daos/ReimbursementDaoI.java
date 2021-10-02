package com.revature.daos;

import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.models.Users;

public interface ReimbursementDaoI {
	
	public List<Reimbursement> getAllReims();
	
	public void addReim(Reimbursement reim);
	
	public List<Reimbursement> getReimsByStatus(ReimbursementStatus status);
	
	public List<Reimbursement> getReimsByUserId(int user_id);
	
	public void updateReimStatus(int reim_id, int reim_status);
	
	public List<Reimbursement> getReimsByStatusId(int id);
	

}
