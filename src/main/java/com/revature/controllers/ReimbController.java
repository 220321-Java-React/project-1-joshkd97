package com.revature.controllers;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.revature.models.ReimbDTO;
import com.revature.models.UserDTO;
import com.revature.services.ReimbService;
import com.revature.models.Reimbursement;
import com.revature.models.UpdateDTO;

import io.javalin.http.Handler;

public class ReimbController {
	
	ReimbService rs = new ReimbService();
	
	public Handler inputReimbHandler = (ctx) -> {
		
		
		if(ctx.req.getSession(true) != null) {
			
			String body = ctx.body();
			
			Gson gson = new Gson();
			
			ReimbDTO rDTO = gson.fromJson(body, ReimbDTO.class);
			
			ctx.status(200);
			//rs.inputReimb(rDTO);
			
			String message = gson.toJson(rs.inputReimb(rDTO));
			ctx.result(message);
			//ctx.status(200);
			
		}
			
	};
	
	public Handler getReimbsByUserHandler = (ctx) -> {
		
		if(ctx.req.getSession(true) != null) {
		
			String body = ctx.body();
			
			Gson gson = new Gson();
			
			UserDTO uDTO = gson.fromJson(body, UserDTO.class);
			
			ArrayList<Reimbursement> reimbs = rs.getReimb(uDTO);
			
			String reimbursements = gson.toJson(reimbs);
			
			ctx.result(reimbursements);
			
			ctx.status(200);
			
		}
	};
	
	public Handler updateReimbHandler = (ctx) -> {
		
		if(ctx.req.getSession(true) != null) {
			
			String body  = ctx.body();
			
			Gson gson = new Gson();
			
			UpdateDTO uDTO = gson.fromJson(body, UpdateDTO.class);
			
			ctx.status(200);
			
			String message = gson.toJson(rs.resolveReimb(uDTO));
			ctx.result(message);
			
		}		
	};
	
	public Handler showAllReimbs = (ctx) -> {
		
		if(ctx.req.getSession(true) != null) {
			
			Gson gson = new Gson();
			
			ArrayList<Reimbursement> reimbs = rs.getAllReimbs();
			
			String reimbursements = gson.toJson(reimbs);
			
			ctx.result(reimbursements);
			ctx.status(200);
		}
		
	};
}
