package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.utils.ConnectionUtil;

public class UserDAO {
	
	RoleDAO rDAO = new RoleDAO();
	
	
	public User getUserbyId(int id) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "select * from users where user_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			User user = new User();
			
			while(rs.next()) {
				user.setUser_id(rs.getInt("user_id"));
				user.setUser_name(rs.getString("user_name"));
				user.setPass_word(rs.getString("pass_word"));
				user.setFirst_name(rs.getString("first_name"));
				user.setLast_name(rs.getString("last_name"));
				user.setEmail(rs.getString("email"));
				
				int role_fk = rs.getInt("role_id_fk");
				
				Role role = rDAO.getRolebyID(role_fk);
				
				user.setRole(role);
			}
			
			return user;
			
			
		}catch(SQLException e) {
			System.out.println("Problem getting user by id");
			e.printStackTrace();
		}
		
		return null;
	}


	public ArrayList<User> getUsers() {
		// TODO Auto-generated method stub
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "select * from users";
			
			Statement s = conn.createStatement();		
			ResultSet rs = s.executeQuery(sql);
			
			ArrayList<User> userList = new ArrayList<>();
			
			while(rs.next()) {
				
					User user= new User(
							rs.getInt("user_id"),
							rs.getString("user_name"),
							rs.getString("pass_word"),
							rs.getString("first_name"),
							rs.getString("last_name"),
							rs.getString("email"),
							null
							);
					
					int role_fk = rs.getInt("role_id_fk");
					
					Role role = rDAO.getRolebyID(role_fk);
					
					user.setRole(role);
					
					userList.add(user);									
		
			}
			
			return userList;
								
		}catch (SQLException e) {
			System.out.println("Something went wrong when logging in");
			e.printStackTrace();
			
		}
		return null;
	}
	
	
	
	
	

}
