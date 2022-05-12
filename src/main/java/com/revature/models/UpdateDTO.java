package com.revature.models;

public class UpdateDTO {
	
	private int reimb_id;
	private int user_id;
	private String status;
	
	
	public UpdateDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public UpdateDTO(int reimb_id, int user_id, String status) {
		super();
		this.reimb_id = reimb_id;
		this.user_id = user_id;
		this.status = status;
	}


	public int getReimb_id() {
		return reimb_id;
	}


	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}
