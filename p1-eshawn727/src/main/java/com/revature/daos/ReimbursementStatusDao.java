package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.revature.models.ReimbursementStatus;
import com.revature.models.ReimbursementType;
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
	
	@Override
	public ReimbursementStatus getStatusById(int id) {
		
		Session ses = HibernateUtil.getSession();
		
		String HQL = "FROM ReimbursementStatus WHERE status_id = '" + id + "'";
		
		Query q = ses.createQuery(HQL);
		
		Object status = q.uniqueResult();
		
		HibernateUtil.closeSession();
		
		return (ReimbursementStatus) status;
		
	}
}
