package com.revature.models;

//LoginDTO is a Data Transfer Object
//http handler will take in a JSON object sent in by the user containing their username and password
//this then gets sent to the controller to get turned into this Java object using Gson
//the username and passowrd the user sent in will be put into this TDO as variables
//you never store a DTO in the database its purely for data trasnfer
public class LoginDTO {
	
	private String user_name;
	private String pass_word;
	
	
	public LoginDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public LoginDTO(String user_name, String pass_word) {
		super();
		this.user_name = user_name;
		this.pass_word = pass_word;
	}


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public String getPass_word() {
		return pass_word;
	}


	public void setPass_word(String pass_word) {
		this.pass_word = pass_word;
	}
	
	

}
