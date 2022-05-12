package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Role;
import com.revature.utils.ConnectionUtil;

public class RoleDAO {
	
	
	public Role getRolebyID(int id) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "select * from roles where role_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				return new Role(
						rs.getInt("role_id"),
						rs.getString("role_title")
						);
			}
			
		}catch(SQLException e) {
			System.out.println("Somethign went wrong when getting employee");
			e.printStackTrace();
		}
		
		return null;
		
	}

}
