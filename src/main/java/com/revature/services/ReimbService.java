package com.revature.services;

import java.util.ArrayList;

import com.revature.daos.ReimbDAO;
import com.revature.models.ReimbDTO;
import com.revature.models.Reimbursement;
import com.revature.models.UpdateDTO;
import com.revature.models.UserDTO;

public class ReimbService {
	
	ReimbDAO rDAO = new ReimbDAO();
	
	
	public String inputReimb(ReimbDTO rdto) {
		
		String inputMessage = "reimbursement has been submitted";
		
		rDAO.insertReimb(rdto);
		
		return inputMessage;
	}
	
	public ArrayList<Reimbursement> getReimb(UserDTO uDTO){
		
		ArrayList<Reimbursement> reimbursements = rDAO.getReimbById(uDTO.getId());
		
		return reimbursements;
		
	}
	
	public String resolveReimb(UpdateDTO uDTO){
		
		String inputMessage = "reimbusrement has been resolved";
		
		rDAO.updateReimb(uDTO);
		
		return inputMessage;
	}
	
	public ArrayList<Reimbursement> getAllReimbs(){
		
		ArrayList<Reimbursement> reimbs = rDAO.getReimbs();
		
		return reimbs;
	}

}
