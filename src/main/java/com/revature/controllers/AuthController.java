package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.models.LoginDTO;
import com.revature.services.AuthService;

import io.javalin.http.Handler;

public class AuthController {
	
	AuthService as = new AuthService();
		
	public Handler employeeLoginHandler = (ctx) -> {
			
		String body = ctx.body();
		
		Gson gson = new Gson();
		
		LoginDTO LTDO = gson.fromJson(body, LoginDTO.class);
		
		if(as.EmployeeLogin(LTDO.getUser_name(), LTDO.getPass_word()) != null) {
			
			ctx.req.getSession();
			ctx.status(202);
			
			System.out.println("Employee Login Successful");
			
			String employeeJSON = gson.toJson(as.EmployeeLogin(LTDO.getUser_name(), LTDO.getPass_word()));
			
			ctx.result(employeeJSON);
		} else {
			
			ctx.status(401);
			System.out.println("Employee Login Failed");
		}	
	};
	
	public Handler managerLoginHandler = (ctx) -> {
		
		String body = ctx.body();
		
		Gson gson = new Gson();
		
		LoginDTO LTDO = gson.fromJson(body, LoginDTO.class);
		
		if(as.ManagerLogin(LTDO.getUser_name(), LTDO.getPass_word()) != null) {
			
			ctx.req.getSession();
			ctx.status(202);
			
			String employeeJSON = gson.toJson(as.ManagerLogin(LTDO.getUser_name(), LTDO.getPass_word()));
			
			System.out.println("Manager Login Successful");
			ctx.result(employeeJSON);
		} else {
			
			ctx.status(401);
			System.out.println("Manager Login Failed");
		}	
	};

}
