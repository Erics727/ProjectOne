package com.revature.models;

public class UpdateDTO {
	
	private int reim_id;
	private int status_id;
	
	public UpdateDTO() {
		super();
		
	}
	
	public UpdateDTO(int reim_id, int status_id) {
		super();
		this.reim_id = reim_id;
		this.status_id = status_id;
	}
	
	public int getReim_id() {
		return reim_id;
	}
	
	public void setReim_id(int reim_id) {
		this.reim_id = reim_id;
	}
	
	public int getStatus_id() {
		return status_id;
	}
	
	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}
}
