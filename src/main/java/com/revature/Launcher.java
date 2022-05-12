package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.controllers.AuthController;
import com.revature.controllers.ReimbController;
import com.revature.daos.ReimbDAO;
import com.revature.daos.UserDAO;
import com.revature.models.ReimbDTO;
import com.revature.models.User;
import com.revature.services.AuthService;
import com.revature.services.ReimbService;
import com.revature.utils.ConnectionUtil;

import io.javalin.Javalin;

public class Launcher {

    public static void main(String[] args) {
    	
    	
    	try(Connection conn = ConnectionUtil.getConnection()){
			System.out.println("CONNECTION SUCCESSFUL :)");
		} catch (SQLException e) { //if creating this connection fails... catch the exception and print the stack trace
			System.out.println("connection failed... :(");
			e.printStackTrace();
		}
    	
    	//here we go again... have fun!!
    	
    	/*
    	  
    	  
		       _.---._    /\\
		    ./'       "--`\//
		  ./              o \
		 /./\  )______   \__ \
		./  / /\ \   | \ \  \ \
		   / /  \ \  | |\ \  \7
		    "     "    "  "        
    	  
    	  
    	  Here's an aardvark this time... not as friendly or cute as a dog, but take him anyway.
    	 
    	 */
    	
    	AuthController ac = new AuthController();
    	ReimbController rc = new ReimbController();
    	
    	Javalin app = Javalin.create(
    			//lambda lets us specify certain configurations
				config -> {
					//allows us to process JS requests 
					config.enableCorsForAllOrigins();
				}
    			).start(3001);
    	
    	app.post("/employeeLogin", ac.employeeLoginHandler);
    	app.post("/managerLogin", ac.managerLoginHandler);
    	app.post("/insertReimb", rc.inputReimbHandler);
    	app.post("/displayReimbsByUser", rc.getReimbsByUserHandler);
    	app.post("/resolveReimb", rc.updateReimbHandler);
    	app.get("/displayReimbs", rc.showAllReimbs);
    	
    	
    	ReimbDAO rDAO = new ReimbDAO();
//    	ReimbDTO rDTO = new ReimbDTO();
//    	
//    	rDTO.setAmount(200);
//    	rDTO.setDescript("Testing Eating");
//    	rDTO.setType("food");
//    	rDTO.setUser_id(1); 	
//    	rDAO.insertReimb(rDTO);
 

   
    //	rDAO.updateReimb(2, 1, "Denied");
    
    }
}
