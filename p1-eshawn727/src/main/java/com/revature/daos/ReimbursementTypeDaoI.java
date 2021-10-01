package com.revature.daos;

import java.util.List;

import com.revature.models.ReimbursementType;

public interface ReimbursementTypeDaoI {
	
	public List<ReimbursementType> getAllTypes();
	
	public void addReimType(ReimbursementType type);

}
