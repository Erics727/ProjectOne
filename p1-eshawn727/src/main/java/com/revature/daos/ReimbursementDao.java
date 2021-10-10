package com.revature.daos;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.utils.HibernateUtil;

public class ReimbursementDao implements ReimbursementDaoI {

	@Override
	public List<Reimbursement> getAllReims() {
		
		Session ses = HibernateUtil.getSession();
		
		List<Reimbursement> reimList = ses.createQuery("FROM Reimbursement ORDER BY reim_id").list();
		
		HibernateUtil.closeSession();
		
		return reimList;
	}

	@Override
	public void addReim(Reimbursement reim) {
		
		Session ses = HibernateUtil.getSession();
		
		ses.save(reim);
		
		HibernateUtil.closeSession();
	}
	
	@Override
	public void updateReimStatus(int reim_id, int reim_status) { 
		
		Session ses = HibernateUtil.getSession();
		
		Transaction tran = ses.beginTransaction();
		
		String HQL = "UPDATE Reimbursement SET reim_status = '" + reim_status + "' WHERE reim_id = " + reim_id;
		
		Query q = ses.createQuery(HQL);
		
		q.executeUpdate();
		
		tran.commit();
		
		HibernateUtil.closeSession();	
	}

	@Override
	public List<Reimbursement> getReimsByStatus(ReimbursementStatus status) {
		
		Session ses = HibernateUtil.getSession();
		
		List<Reimbursement> reimList = ses.createQuery("FROM Reimbursement WHERE reim_status = '" + status.getStatus_id() + "' ORDER BY reim_id").list();
		
		HibernateUtil.closeSession();
		
		return reimList;
	}
	
	@Override
	public List<Reimbursement> getReimsByStatusId(int id) {
		
		Session ses = HibernateUtil.getSession();
		
		List<Reimbursement> reimList = ses.createQuery("FROM Reimbursement WHERE reim_status = '" + id + "' ORDER BY reim_id").list();
		
		HibernateUtil.closeSession();
		
		return reimList;
	}

	
	@Override
	public Reimbursement getReimsById(int id) {
		
		Session ses = HibernateUtil.getSession();
		
		Object reim = ses.createQuery("FROM Reimbursement WHERE reim_id = '" + id + "'").uniqueResult();
		
		HibernateUtil.closeSession();
		
		return (Reimbursement) reim;	
	}
	
	
	@Override
	public List<Reimbursement> getReimsByUserId(int user_id) {
		
		Session ses = HibernateUtil.getSession();
		
		List<Reimbursement> reimList = ses.createQuery("FROM Reimbursement WHERE reim_author = '" + user_id + "' ORDER BY reim_id").list();
		
		HibernateUtil.closeSession();
		
		return reimList;
	}
}
