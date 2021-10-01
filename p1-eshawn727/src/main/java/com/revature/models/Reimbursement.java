package com.revature.models;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Reimbursements")
public class Reimbursement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reim_id")
	private int reim_id;
	
	private double amount;
	private Timestamp created;
	private String description;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private Users reim_author;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "status_id")
	private ReimbursementStatus reim_status;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "type_id")
	private ReimbursementType reim_type;
	
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reimbursement(int reim_id, double amount, Timestamp created, String description, Users reim_author,
			ReimbursementStatus reim_status, ReimbursementType reim_type) {
		super();
		this.reim_id = reim_id;
		this.amount = amount;
		this.created = created;
		this.description = description;
		this.reim_author = reim_author;
		this.reim_status = reim_status;
		this.reim_type = reim_type;
	}	

	public Reimbursement(double amount, Timestamp created, String description, Users reim_author,
			ReimbursementStatus reim_status, ReimbursementType reim_type) {
		super();
		this.amount = amount;
		this.created = created;
		this.description = description;
		this.reim_author = reim_author;
		this.reim_status = reim_status;
		this.reim_type = reim_type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((reim_author == null) ? 0 : reim_author.hashCode());
		result = prime * result + reim_id;
		result = prime * result + ((reim_status == null) ? 0 : reim_status.hashCode());
		result = prime * result + ((reim_type == null) ? 0 : reim_type.hashCode());
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
		Reimbursement other = (Reimbursement) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (reim_author == null) {
			if (other.reim_author != null)
				return false;
		} else if (!reim_author.equals(other.reim_author))
			return false;
		if (reim_id != other.reim_id)
			return false;
		if (reim_status == null) {
			if (other.reim_status != null)
				return false;
		} else if (!reim_status.equals(other.reim_status))
			return false;
		if (reim_type == null) {
			if (other.reim_type != null)
				return false;
		} else if (!reim_type.equals(other.reim_type))
			return false;
		return true;
	}	

	public int getReim_id() {
		return reim_id;
	}

	public void setReim_id(int reim_id) {
		this.reim_id = reim_id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Timestamp getcreated() {
		return created;
	}

	public void setcreated(Timestamp created) {
		this.created = created;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Users getReim_author() {
		return reim_author;
	}

	public void setReim_author(Users reim_author) {
		this.reim_author = reim_author;
	}

	public ReimbursementStatus getReim_status() {
		return reim_status;
	}

	public void setReim_status(ReimbursementStatus reim_status) {
		this.reim_status = reim_status;
	}

	public ReimbursementType getReim_type() {
		return reim_type;
	}

	public void setReim_type(ReimbursementType reim_type) {
		this.reim_type = reim_type;
	}

	/*
	public String toString() {
		return "Reimbursement [reim_id=" + reim_id + ", amount=" + amount + ", created=" + created
				+ ", description=" + description + ", reim_author=" + reim_author + ", reim_status=" + reim_status
				+ ", reim_type=" + reim_type + "]";
	}
	*/

	//CHANGE ME
	@Override
	public String toString() {
		return "Reimbursement [reim_id=" + reim_id + ", amount=" + amount + ", created=" + created
				+ ", description=" + description + ", reim_author=" + reim_author.getfName() + " " + reim_author.getlName()
				+ ", reim_status=" + reim_status.getStatus() + ", reim_type=" + " " + reim_type.getType() + "]";
	}
	
	
	
		
}
