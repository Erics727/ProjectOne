package com.revature.daos;

import java.util.List;

import org.hibernate.Session;

import com.revature.models.ReimbursementStatus;
import com.revature.utils.HibernateUtil;

public class ReimbursementStatusDao implements ReimbursementStatusDaoI{

	@Override
	public List<ReimbursementStatus> getAllStatus() {
		// TODO Auto-generated method stub
		Session ses = HibernateUtil.getSession();
		
		List<ReimbursementStatus> statusList = ses.createQuery("FROM ReimbursementStatus").list();
		
		HibernateUtil.closeSession();
		
		return statusList;
	}

	@Override
	public void addStatus(ReimbursementStatus status) {
		// TODO Auto-generated method stub
		Session ses = HibernateUtil.getSession();
		
		ses.save(status);
		
		HibernateUtil.closeSession();			
	}
}
