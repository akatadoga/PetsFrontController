package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.UserRoles;
import com.example.model.Users;

public class UsersImpl implements UsersDao {
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
    
//	@Override
//	public int insertUsers(Users p) {
//		try (Connection conn = DriverManager.getConnection(url, username, password)) {
//
//			PreparedStatement ps = conn.prepareStatement("INSERT INTO ERS_USERS VALUES(?,?)");
//			ps.setString(1,p.getName());
//			ps.setString(2, p.getPassword());
//			System.out.println(p);
//			ps.executeUpdate();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		System.out.println("ADANA");
//		return 0;
//	}
    
    // Returns a Users object of the passed username.
    
	@Override
	public Users selectUsers(String name) {
		Users users = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_USERS WHERE ERS_USERNAME=?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int userid = rs.getInt("ERS_USERS_ID");
				String usernamee = rs.getString("ERS_USERNAME");
				String passwordd = rs.getString("ERS_PASSWORD");
				String firstName = rs.getString("USER_FIRST_NAME");
				String lastName = rs.getString("USER_LAST_NAME");
				String email = rs.getString("USER_EMAIL");
				
				int roleId = rs.getInt("USER_ROLE_ID");
//				UserRoles role = null;
//				if(roleId != 0){
//					UserRolesImpl roleDAO = new UserRolesImpl();
//					role = roleDAO.createRoleObj(roleId);
//				}	
				if (users == null) {
					users= new Users(0,",",",",",",",",",",0);
				}
				users = new Users(userid,usernamee,passwordd,firstName,lastName,email,roleId);
				
			}
			//users = new Users(userid,usernamee,passwordd,firstName,lastName,email,roleId);
				//users = new Users(rs.getString(1),rs.getString(2));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Users object: " + users);
		return users;
	}
	
	// Select Users by password
	
	@Override
	public Users selectUsersByPassword(String USER_PASSWORD) {
		Users users = null;
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_USERS WHERE ERS_PASSWORD=?");
			ps.setString(1, USER_PASSWORD);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int userid = rs.getInt("ERS_USERS_ID");
				String usernamee = rs.getString("ERS_USERNAME");
				String passwordd = rs.getString("ERS_PASSWORD");
				String firstName = rs.getString("USER_FIRST_NAME");
				String lastName = rs.getString("USER_LAST_NAME");
				String email = rs.getString("USER_EMAIL");
				
				int roleId = rs.getInt("USER_ROLE_ID");
//				UserRoles role = null;
//				if(roleId != 0){
//					UserRolesImpl roleDAO = new UserRolesImpl();
//					role = roleDAO.createRoleObj(roleId);
//				}	
//				if (users == null) {
//					users= new Users(0,",",",",",",",",",",0);
//				}
				users = new Users(userid,usernamee,passwordd,firstName,lastName,email,roleId);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Users object: " + users);
		return users;
	}
	
	
	// Select Users by ID
	
		@Override
		public Users selectUsersByID(int USER_ID) {
			Users users = null;
			try (Connection conn = DriverManager.getConnection(url, username, password)) {
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_USERS WHERE ERS_USERS_ID=?");
				ps.setInt(1, USER_ID);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					int userid = rs.getInt("ERS_USERS_ID");
					String usernamee = rs.getString("ERS_USERNAME");
					String passwordd = rs.getString("ERS_PASSWORD");
					String firstName = rs.getString("USER_FIRST_NAME");
					String lastName = rs.getString("USER_LAST_NAME");
					String email = rs.getString("USER_EMAIL");
					
					int roleId = rs.getInt("USER_ROLE_ID");
//					UserRoles role = null;
//					if(roleId != 0){
//						UserRolesImpl roleDAO = new UserRolesImpl();
//						role = roleDAO.createRoleObj(roleId);
//					}	
//					if (users == null) {
//						users= new Users(0,",",",",",",",",",",0);
//					}
					users = new Users(userid,usernamee,passwordd,firstName,lastName,email,roleId);
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("Users object: " + users);
			return users;
		}
		
		//select all users
		
		@Override
		public List<Users> selectAllUsers() {
			List<Users> userArray = new ArrayList<Users>();
			try (Connection conn = DriverManager.getConnection(url, username, password)) {
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM ERS_USERS WHERE ERS_USERS_ID=?");
				//ps.setInt(1, USER_ID);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					int userid = rs.getInt("ERS_USERS_ID");
					String usernamee = rs.getString("ERS_USERNAME");
					String passwordd = rs.getString("ERS_PASSWORD");
					String firstName = rs.getString("USER_FIRST_NAME");
					String lastName = rs.getString("USER_LAST_NAME");
					String email = rs.getString("USER_EMAIL");
					int roleId = rs.getInt("USER_ROLE_ID");
//					UserRoles role = null;
//					if(roleId != 0){
//						UserRolesImpl roleDAO = new UserRolesImpl();
//						role = roleDAO.createRoleObj(roleId);
//					}	
//					if (users == null) {
//						users= new Users(0,",",",",",",",",",",0);
//					}
					userArray.add(new Users(userid,usernamee,passwordd,firstName,lastName,email,roleId));
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//System.out.println("Users object: " + userArray);
			return userArray;
		}
//	@Override
//	public int updatePet(Pet p) {
//		try (Connection conn = DriverManager.getConnection(url, username, password)) {
//
//			PreparedStatement ps = conn.prepareStatement("INSERT INTO Pets VALUES(?,?)");
//			ps.setString(1,p.getName());
//			ps.setString(2, p.getType());
//			System.out.println(p);
//			ps.executeUpdate();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return 0;
//	}

}