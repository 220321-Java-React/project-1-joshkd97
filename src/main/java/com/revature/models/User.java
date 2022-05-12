package com.revature.models;

public class User {
	
	private int user_id;
	private String user_name;
	private String pass_word;
	private String first_name;
	private String last_name;
	private String email;
	private Role role;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(int user_id, String user_name, String pass_word, String first_name, String last_name, String email,
			Role role) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.pass_word = pass_word;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.role = role;
	}


	public User(String user_name, String pass_word, String first_name, String last_name, String email, Role role) {
		super();
		this.user_name = user_name;
		this.pass_word = pass_word;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.role = role;
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
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


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", pass_word=" + pass_word + ", first_name="
				+ first_name + ", last_name=" + last_name + ", email=" + email + ", role=" + role + "]";
	}
	
	
	

}
