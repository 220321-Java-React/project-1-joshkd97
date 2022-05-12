package com.revature.services;

import java.util.ArrayList;

import com.revature.daos.UserDAO;
import com.revature.models.User;

public class AuthService {
	
	UserDAO uDAO = new UserDAO();
	
	public User ManagerLogin(String username, String password) {
		
		ArrayList<User> userList = uDAO.getUsers();
		
		for(User u: userList) {
			
			if(username.equals(u.getUser_name()) && password.equals(u.getPass_word()) && u.getRole().getRole_id() == 2) {
				
				return u;
			}	
		}  
			return null;
	}
	
	public User EmployeeLogin(String username, String password) {
		
		ArrayList<User> userList = uDAO.getUsers();
		
		for(User u: userList) {
			
			if(username.equals(u.getUser_name()) && password.equals(u.getPass_word()) && u.getRole().getRole_id() == 1) {
				
				return u;
			}	
		}  
			return null;
	}

}
