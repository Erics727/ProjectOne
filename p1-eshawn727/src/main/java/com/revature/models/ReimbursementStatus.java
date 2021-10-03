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
@Table(name = "Reimbursement_Status")
public class ReimbursementStatus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "status_id")
	private int status_id;
	
	private String status;
	
	//@OneToMany(mappedBy="reim_status", fetch = FetchType.EAGER)
	//private List<Reimbursement> statusByReim;

	public ReimbursementStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReimbursementStatus(int status_id, String status/*, List<Reimbursement> statusByReim*/) {
		super();
		this.status_id = status_id;
		this.status = status;
		//this.statusByReim = statusByReim;
	}
/*
	public ReimbursementStatus(String status, List<Reimbursement> statusByReim) {
		super();
		this.status = status;
		this.statusByReim = statusByReim;
	}
*/
	public ReimbursementStatus(String status) {
		super();
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		//result = prime * result + ((statusByReim == null) ? 0 : statusByReim.hashCode());
		result = prime * result + status_id;
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
		ReimbursementStatus other = (ReimbursementStatus) obj;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		//if (statusByReim == null) {
		//	if (other.statusByReim != null)
		//		return false;
		//} else if (!statusByReim.equals(other.statusByReim))
		//	return false;
		if (status_id != other.status_id)
			return false;
		return true;
	}

	public int getStatus_id() {
		return status_id;
	}

	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
/*
	public List<Reimbursement> getStatusByReim() {
		return statusByReim;
	}

	public void setStatusByReim(List<Reimbursement> statusByReim) {
		this.statusByReim = statusByReim;
	}
*/
	@Override
	public String toString() {
		return "ReimbursementStatus [status_id=" + status_id + ", status=" + status /*+ ", statusByReim=" + statusByReim*/
				+ "]";
	}

	

}
