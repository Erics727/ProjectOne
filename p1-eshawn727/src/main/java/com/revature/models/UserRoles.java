package com.revature.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "User_Roles")
public class UserRoles {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private int role_id;
	
	private String role;
	
	//@OneToMany(mappedBy="user_role", fetch = FetchType.EAGER)
	//private List<Users> roleByUser;

	public UserRoles() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRoles(int role_id, String role, List<Users> roleByUser) {
		super();
		this.role_id = role_id;
		this.role = role;
		//this.roleByUser = roleByUser;
	}
/*
	public UserRoles(String role, List<Users> roleByUser) {
		super();
		this.role = role;
		this.roleByUser = roleByUser;
	}
*/
	public UserRoles(String role) {
		super();
		this.role = role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		//result = prime * result + ((roleByUser == null) ? 0 : roleByUser.hashCode());
		result = prime * result + role_id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRoles other = (UserRoles) obj;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		//if (roleByUser == null) {
		//	if (other.roleByUser != null)
		//		return false;
		//} else if (!roleByUser.equals(other.roleByUser))
		//	return false;
		if (role_id != other.role_id)
			return false;
		return true;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
/*
	public List<Users> getRoleByUser() {
		return roleByUser;
	}

	public void setRoleByUser(List<Users> roleByUser) {
		this.roleByUser = roleByUser;
	}
*/
	@Override
	public String toString() {
		return "UserRoles [role_id=" + role_id + ", role=" + role /*+ ", roleByUser=" + roleByUser*/ + "]";
	}
	
	
	


}
