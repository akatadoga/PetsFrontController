package com.example.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.dao.UserRolesImpl;

public class sacma {
	
		private Connection conn;

		public sacma(Connection conn) {
			super();
			this.conn = conn;
		}
		
		/**
		 * Returns a Users object of the passed username.
		 * @param givenUsername
		 * @return
		 * @throws SQLException
		 */
		public Users getUserInfoByUsername(String givenUsername) throws SQLException{
			String sql = "SELECT * FROM ERS_USERS " +
						 "WHERE ERS_USERNAME = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, givenUsername);
			ResultSet rs = stmt.executeQuery();
			Users obj = null;
			while(rs.next()){
				int id = rs.getInt("ERS_USERS_ID");
				String username = rs.getString("ERS_USERNAME");
				String password = rs.getString("ERS_PASSWORD");
				String firstName = rs.getString("USER_FIRST_NAME");
				String lastName = rs.getString("USER_LAST_NAME");
				String email = rs.getString("USER_EMAIL");
				
				int roleId = rs.getInt("USER_ROLE_ID");
				UserRoles role = null;
				if(roleId != 0){
					UserRolesImpl roleDAO = new UserRolesImpl();
					role = roleDAO.createRoleObj(roleId);
				}
				
				obj = new Users(id,username,password,firstName,lastName,email,role);
			}
			System.out.println("Users object: " +obj);
			return obj;
		}
}
