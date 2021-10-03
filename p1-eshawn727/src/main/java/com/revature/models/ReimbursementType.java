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
@Table(name = "Reimbursement_Type")
public class ReimbursementType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "type_id")
	private int type_id;
	
	private String type;
	
	//@OneToMany(mappedBy="reim_type", fetch=FetchType.EAGER)
	//private List<Reimbursement> typeByReim;

	public ReimbursementType() {
		super();
		// TODO Auto-generated constructor stub
	}
/*
	public ReimbursementType(int type_id, String type, List<Reimbursement> typeByReim) {
		super();
		this.type_id = type_id;
		this.type = type;
		this.typeByReim = typeByReim;
	}
*/
	public ReimbursementType(int type_id, String type) {
		super();
		this.type_id = type_id;
		this.type = type;
	}

	public ReimbursementType(String type) {
		super();
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		//result = prime * result + ((typeByReim == null) ? 0 : typeByReim.hashCode());
		result = prime * result + type_id;
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
		ReimbursementType other = (ReimbursementType) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		//if (typeByReim == null) {
		//	if (other.typeByReim != null)
		//		return false;
		//} else if (!typeByReim.equals(other.typeByReim))
		//	return false;
		//if (type_id != other.type_id)
		//	return false;
		return true;
	}

	public int getType_id() {
		return type_id;
	}

	public void setType_id(int type_id) {
		this.type_id = type_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
/*
	public List<Reimbursement> getTypeByReim() {
		return typeByReim;
	}

	public void setTypeByReim(List<Reimbursement> typeByReim) {
		this.typeByReim = typeByReim;
	}
*/
	@Override
	public String toString() {
		return "ReimbursementType [type_id=" + type_id + ", type=" + type /*+ ", typeByReim=" + typeByReim*/ + "]";
	}

	
	
}
