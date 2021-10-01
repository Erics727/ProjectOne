package com.revature.daos;

import java.util.List;

import org.hibernate.Session;

import com.revature.models.ReimbursementType;
import com.revature.utils.HibernateUtil;

public class ReimbursementTypeDao implements ReimbursementTypeDaoI{

	@Override
	public List<ReimbursementType> getAllTypes() {
		// TODO Auto-generated method stub
		Session ses = HibernateUtil.getSession();
		
		List<ReimbursementType> typeList = ses.createQuery("FROM ReimbursementType").list();
		
		HibernateUtil.closeSession();
		
		return typeList;
	}

	@Override
	public void addReimType(ReimbursementType type) {
		// TODO Auto-generated method stub
		Session ses = HibernateUtil.getSession();
		
		ses.save(type);
		
		HibernateUtil.closeSession();
		
	}

}
