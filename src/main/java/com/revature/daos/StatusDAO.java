package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.ReimbStatus;
import com.revature.utils.ConnectionUtil;

public class StatusDAO {
	
	public ReimbStatus getStatusById(int id) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			
			String sql = "select * from reimbursement_status where reimb_status_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				
				return new ReimbStatus(
						rs.getInt("reimb_status_id"),
						rs.getString("reimb_status")
						
						);
				
			}
				
		}catch(SQLException e) {
			
			System.out.println("There was an issue getting the reimb status by Id");
			e.printStackTrace();
		}
		
		return null;
		
	}

}
