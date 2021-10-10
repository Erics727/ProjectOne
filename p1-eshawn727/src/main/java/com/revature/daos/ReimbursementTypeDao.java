package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.revature.models.ReimbursementType;
import com.revature.utils.HibernateUtil;

public class ReimbursementTypeDao implements ReimbursementTypeDaoI{

	@Override
	public List<ReimbursementType> getAllTypes() {
		
		Session ses = HibernateUtil.getSession();
		
		List<ReimbursementType> typeList = ses.createQuery("FROM ReimbursementType").list();
		
		HibernateUtil.closeSession();
		
		return typeList;
	}

	@Override
	public void addReimType(ReimbursementType type) {
		
		Session ses = HibernateUtil.getSession();
		
		ses.save(type);
		
		HibernateUtil.closeSession();
	}

	@Override
	public ReimbursementType getReimType(int id) {
		
		Session ses = HibernateUtil.getSession();
		
		String HQL = "FROM ReimbursementType WHERE type_id = '" + id + "'";
		
		Query q = ses.createQuery(HQL);
		
		Object type = q.uniqueResult();
		
		HibernateUtil.closeSession();
		
		return (ReimbursementType) type;
	}
}
