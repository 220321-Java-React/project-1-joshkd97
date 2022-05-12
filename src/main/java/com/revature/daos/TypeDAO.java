package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.ReimbType;
import com.revature.utils.ConnectionUtil;

public class TypeDAO {
	
	public ReimbType getTypeById(int id) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "select * from reimbursement_types where reimb_type_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				return new ReimbType(
						rs.getInt("reimb_type_id"),
						rs.getString("reimb_type")
						);
			}
			
			
		}catch(SQLException e) {
			System.out.println("There was a problem getting the reimb type by id");
			e.printStackTrace();
		}
		
		return null;
	}

}
