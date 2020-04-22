package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {
	
	//the idea behind this class is to route requests 
	//based on the URI that comes along with the request
	
	public static String process(HttpServletRequest request, HttpServletResponse response) {

		System.out.println(request.getRequestURI());
		//System.out.println("Hello");
		
		switch(request.getRequestURI()) {
		
//		case "/PetsFrontController/html/Login.do":
//			return LoginController.Login(request);
//			
//		case "/PetsFrontController/html/Register.do":
//			System.out.println("in request helper");
//			return RegisterController.Register(request);
//			
//		case "/PetsFrontController/html/Home.do":
//			System.out.println("in do");
//			return HomeController.Home(request, response);
//			
//		case "/PetsFrontController/html/Update.do":
//			
//			return ProfileController.Update(request);
			
		case "/PetsFrontController/html/Login.do":
			return LoginUsersController.Login(request);
			
		default:
			return "/html/Login.html";
		}
	}

}
