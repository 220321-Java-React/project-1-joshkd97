package com.revature.models;

public class ReimbDTO {
	
	private int amount;
	private int user_id;
	private String descript;
	private String type;
	
	
	public ReimbDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ReimbDTO(int amount, int user_id, String descript, String type) {
		super();
		this.amount = amount;
		this.user_id = user_id;
		this.descript = descript;
		this.type = type;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public String getDescript() {
		return descript;
	}


	public void setDescript(String descript) {
		this.descript = descript;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}
	

	

}
