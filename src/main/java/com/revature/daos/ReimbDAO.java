package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.revature.models.ReimbDTO;
import com.revature.models.ReimbStatus;
import com.revature.models.ReimbType;
import com.revature.models.Reimbursement;
import com.revature.models.UpdateDTO;
import com.revature.models.User;
import com.revature.utils.ConnectionUtil;

import sun.security.mscapi.CKeyPairGenerator.RSA;

public class ReimbDAO {
	
	StatusDAO sDAO = new StatusDAO();
	TypeDAO tDAO = new TypeDAO();
	UserDAO uDAO = new UserDAO();
	
	public void insertReimb(ReimbDTO rdto) {
		
	//	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
		
		LocalDateTime ld = LocalDateTime.now();
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "insert into reimbursements(amount, time_submitted, description, author, reimb_status_id, reimb_type_id)"
					+"values (?, ?, ?, ?, ?, ?)";
			
			PreparedStatement ps = conn.prepareCall(sql);
			
			ps.setInt(1, rdto.getAmount());
			ps.setObject(2, ld);
			ps.setString(3, rdto.getDescript());
			ps.setInt(4, rdto.getUser_id());
			ps.setInt(5, 1);
			
			if(rdto.getType().equals("lodging")){
				ps.setInt(6, 1);
			}else if(rdto.getType().equals("travel")) {
				ps.setInt(6, 2);
			}else if(rdto.getType().equals("food")) {
				ps.setInt(6, 3);
			}else if(rdto.getType().equals("other")) {
				ps.setInt(6, 4);
			}
			
			
			ps.executeUpdate();
			
			
			System.out.println("successfully inserting reimb into database");
		
		}catch(SQLException e) {
			System.out.println("There was an issue inserting reimb to the database");
			e.printStackTrace();
		}
	}
	
	public ArrayList<Reimbursement> getReimbById(int id){
		
		try (Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "select * from reimbursements where author = ?";
			
			 PreparedStatement ps = conn.prepareStatement(sql);
			 
			 ps.setInt(1, id);
			 
			 ResultSet rs = ps.executeQuery();
			 
			 ArrayList<Reimbursement> reimbsList = new ArrayList<>();
			 
			 
			 while (rs.next()) {
				 
				 Reimbursement reimbs = new Reimbursement(
						 rs.getInt("reimb_id"),
						 rs.getInt("amount"),
						 rs.getString("time_submitted"),
						 rs.getString("time_resolved"),
						 rs.getString("description"),
						 null,
						 null,
						 null,
						 null
						 );
				 int author_fk = rs.getInt("author");
				 int resolver_fk = rs.getInt("resolver");
				 int status_fk = rs.getInt("reimb_status_id");
				 int type_fk = rs.getInt("reimb_type_id");
				 
				 User author = uDAO.getUserbyId(author_fk);
				 reimbs.setAuthor(author);
				 
				 User resolver = uDAO.getUserbyId(resolver_fk);
				 reimbs.setResolver(resolver);
				 
				 ReimbStatus status = sDAO.getStatusById(status_fk);
				 reimbs.setStatus(status);
				 
				 ReimbType type = tDAO.getTypeById(type_fk);
				 reimbs.setType(type);
				 
				
				 reimbsList.add(reimbs);
			 }
			 
			 System.out.println("Reimbursements have been successfully returned");
			 
			 return reimbsList;
			
		}catch(SQLException e) {
			System.out.println("Something went wrong when showing reimbursments by id");
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void updateReimb (UpdateDTO uDTO) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "update reimbursements set time_resolved = ?, resolver = ?, reimb_status_id = ? where reimb_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			LocalDateTime ld = LocalDateTime.now();
			
			ps.setObject(1, ld);
			ps.setInt(2, uDTO.getUser_id());
			
			if(uDTO.getStatus().equals("Approved")) {
				ps.setInt(3, 2);
			}else if(uDTO.getStatus().equals("Denied")) {
				ps.setInt(3, 3);
			}
			
			ps.setInt(4, uDTO.getReimb_id());
			
			ps.executeUpdate();
			
			System.out.println("Successfully update reimbursement");
			
		}catch(SQLException e) {
			System.out.println("something went wrong when updating the reimbursement");
			e.printStackTrace();
		}
	}
	
	public ArrayList<Reimbursement> getReimbs(){
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "select * from reimbursements";
			
			Statement s = conn.createStatement();
			
			ResultSet rs = s.executeQuery(sql);
			
			ArrayList<Reimbursement> reimbursements = new ArrayList<>();
			
				while (rs.next()) {
				 
				 Reimbursement reimbs = new Reimbursement(
						 rs.getInt("reimb_id"),
						 rs.getInt("amount"),
						 rs.getString("time_submitted"),
						 rs.getString("time_resolved"),
						 rs.getString("description"),
						 null,
						 null,
						 null,
						 null
						 );
				 int author_fk = rs.getInt("author");
				 int resolver_fk = rs.getInt("resolver");
				 int status_fk = rs.getInt("reimb_status_id");
				 int type_fk = rs.getInt("reimb_type_id");
				 
				 User author = uDAO.getUserbyId(author_fk);
				 reimbs.setAuthor(author);
				 
				 User resolver = uDAO.getUserbyId(resolver_fk);
				 reimbs.setResolver(resolver);
				 
				 ReimbStatus status = sDAO.getStatusById(status_fk);
				 reimbs.setStatus(status);
				 
				 ReimbType type = tDAO.getTypeById(type_fk);
				 reimbs.setType(type);
				 
				
				 reimbursements.add(reimbs);
			 }
				
				System.out.println("Reimbursements have been successfully returned");
			 
			 return reimbursements;
			 
		}catch(SQLException e) {
			
			System.out.println("Something went wrong when getting the Reimbursements");
			e.printStackTrace();
		}
		
		return null;
	}

}
