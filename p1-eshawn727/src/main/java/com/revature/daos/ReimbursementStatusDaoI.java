package com.revature.daos;

import java.util.List;

import com.revature.models.ReimbursementStatus;

public interface ReimbursementStatusDaoI {
	
	public List<ReimbursementStatus> getAllStatus();
	
	public void addStatus(ReimbursementStatus status);

}
