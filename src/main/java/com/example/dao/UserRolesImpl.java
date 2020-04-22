package com.example.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.model.UserRoles;
import com.example.model.Users;

public class UserRolesImpl {

		static{
		       try {
		           Class.forName("oracle.jdbc.driver.OracleDriver");
		       } catch (ClassNotFoundException e) {
		           e.printStackTrace();
		       }
		   }
	// ENDPOINT revaturepega1028.c6hcjsxpeox2.us-east-1.rds.amazonaws.com
	private static String url = "jdbc:oracle:thin:@revaturepega1028.c6hcjsxpeox2.us-east-1.rds.amazonaws.com:1521:ORCL";
	private static String username = "Project1";
	private static String password = "p4ssw0rd";
	
	
	
	public UserRoles createRoleObj(int roleId) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT USER_ROLE FROM ERS_USER_ROLES " +  "WHERE ERS_USER_ROLE_ID = ?");
			ps.setInt(1, roleId);
			ResultSet rs = ps.executeQuery();
			rs.next();
			String role = rs.getString("USER_ROLE");
			UserRoles roleObj = new UserRoles();
			obj = roleObj(roleId, role);
				
		//users = new Users(rs.getString(1),rs.getString(2));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(obj);
		return obj;
			
	}
}
