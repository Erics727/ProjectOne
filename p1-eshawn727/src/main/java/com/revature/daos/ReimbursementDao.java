package com.revature.daos;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementStatus;
import com.revature.models.Users;
import com.revature.utils.HibernateUtil;

public class ReimbursementDao implements ReimbursementDaoI {

	@Override
	public List<Reimbursement> getAllReims() {
		// TODO Auto-generated method stub
		Session ses = HibernateUtil.getSession();
		
		List<Reimbursement> reimList = ses.createQuery("FROM Reimbursement").list();
		
		HibernateUtil.closeSession();
		
		return reimList;
	}

	@Override
	public void addReim(Reimbursement reim) {
		// TODO Auto-generated method stub
		Session ses = HibernateUtil.getSession();
		
		ses.save(reim);
		
		HibernateUtil.closeSession();
		
	}

	@Override
	public void updateReimStatus(Reimbursement reim ,ReimbursementStatus status) { 
		// TODO Auto-generated method stub
		Session ses = HibernateUtil.getSession();
		Transaction tran = ses.beginTransaction();
		
		String HQL = "UPDATE Reimbursement SET reim_status = '" + status.getStatus_id() + "' WHERE reim_id = " + reim.getReim_id();
		
		Query q = ses.createQuery(HQL);
		
		q.executeUpdate();
		
		tran.commit();
		HibernateUtil.closeSession();
		
	}

	@Override
	public List<Reimbursement> getReimsByStatus(ReimbursementStatus status) {
		// TODO Auto-generated method stub
		Session ses = HibernateUtil.getSession();
		
		List<Reimbursement> reimList = ses.createQuery("FROM Reimbursement WHERE reim_status =" + status.getStatus_id()).list();
		
		HibernateUtil.closeSession();
		
		return reimList;
	}
	
	@Override
	public List<Reimbursement> getReimsByStatusId(int id) {
		// TODO Auto-generated method stub
		Session ses = HibernateUtil.getSession();
		
		List<Reimbursement> reimList = ses.createQuery("FROM Reimbursement WHERE reim_status =" + id).list();
		
		HibernateUtil.closeSession();
		
		return reimList;
	}

	@Override
	public List<Reimbursement> getReimsById(Users user) {
		// TODO Auto-generated method stub
		Session ses = HibernateUtil.getSession();
		
		List<Reimbursement> reimList = ses.createQuery("FROM Reimbursement WHERE reim_author =" + user.getUser_id()).list();
		
		HibernateUtil.closeSession();
		
		return reimList;
		
	}

}
