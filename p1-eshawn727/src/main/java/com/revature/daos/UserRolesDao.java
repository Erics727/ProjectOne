package com.revature.daos;

import java.util.List;

import org.hibernate.Session;

import com.revature.models.UserRoles;
import com.revature.utils.HibernateUtil;

public class UserRolesDao implements UserRolesDaoI {
	
	@Override
	public void addUserRole(UserRoles role) {
		
		Session ses = HibernateUtil.getSession();
		
		ses.save(role);
		
		HibernateUtil.closeSession();
		
	}

	@Override
	public List<UserRoles> getAllUserRoles() {
		// TODO Auto-generated method stub
		Session ses = HibernateUtil.getSession();
		
		List<UserRoles> rolesList = ses.createQuery("FROM UserRoles").list();
		
		HibernateUtil.closeSession();
		
		return rolesList;
	}

}
