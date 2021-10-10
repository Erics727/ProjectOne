package com.revature.models;

public class ReimbursementDTO {
	
	private double amount;
	private String description;
	private int user_id;
	private int reim_type;
	
	public ReimbursementDTO() {
		super();
		
	}

	public ReimbursementDTO(double amount, String description, int user_id, int reim_type) {
		super();
		this.amount = amount;
		this.description = description;
		this.user_id = user_id;
		this.reim_type = reim_type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getReim_type() {
		return reim_type;
	}

	public void setReim_type(int reim_type) {
		this.reim_type = reim_type;
	}
}
