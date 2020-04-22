package com.example.controller;
import javax.servlet.http.HttpServletRequest;
import com.example.dao.UsersImpl;
import com.example.model.Users;
public class LoginUsersController {

	public static String Login(HttpServletRequest request) {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		UsersImpl usersImpl = new UsersImpl();
		Users users = new Users();
		users = usersImpl.selectUsers(name);
		//we are retrieving an existing record by the pet's name
		//that the user provided on the login page
		//and we are storing it into a pet object
		System.out.println(users);
		System.out.println(name);
		System.out.println(users.getName()+users.getPassword());
		if(name.equals(users.getName()) && password.equals(users.getPassword())) {
			//we are setting the session to the current logged in pet
			request.getSession().setAttribute("Users", users);
			if(users.getRole()==1)
				return "/html/EmployeeMainMenu.html";
			else
				return "/html/ManagerMainMenu.html";
			
		}
		
		return "/html/Index.html";
	}
}


