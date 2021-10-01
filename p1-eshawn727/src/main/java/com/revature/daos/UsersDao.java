package com.revature.daos;

import java.util.List;

import org.hibernate.Session;

import com.revature.models.Reimbursement;
import com.revature.models.Users;
import com.revature.utils.HibernateUtil;

public class UsersDao implements UsersDaoI {
	
	public void addUser(Users user) {
		
		Session ses = HibernateUtil.getSession();
		
		ses.save(user);
		
		HibernateUtil.closeSession();
		
	}

	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		Session ses = HibernateUtil.getSession();
		
		List<Users> usersList = ses.createQuery("FROM Users").list();
		
		HibernateUtil.closeSession();
		
		return usersList;	
	}
	
	//Add dao for list of users??

}
