package com.revature.daos;

import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.models.Users;

public interface ReimbursementDaoI {
	
	public List<Reimbursement> getAllReims();
	
	public void addReim(Reimbursement reim);
	
	public List<Reimbursement> getReimsByStatus(ReimbursementStatus status);
	
	public List<Reimbursement> getReimsById(Users user);
	
	public void updateReimStatus(Reimbursement reim,ReimbursementStatus status);
	
	public List<Reimbursement> getReimsByStatusId(int id);
	

}
