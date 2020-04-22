package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import com.example.dao.PetDaoImpl;
import com.example.model.Pet;

public class LoginController {
	
	
	public static String Login(HttpServletRequest request) {
		String name = request.getParameter("name");
		String type = request.getParameter("type");//password
		
		PetDaoImpl petDaoImpl = new PetDaoImpl();
		Pet pet = new Pet();
		pet = petDaoImpl.selectPetByName(name);
		//we are retrieving an existing record by the pet's name
		//that the user provided on the login page
		//and we are storing it into a pet object
		System.out.println(pet);
		
		if(name.equals(pet.getName()) && type.equals(pet.getType())) {
			//we are setting the session to the current logged in pet
			request.getSession().setAttribute("Pet", pet);
			return "/html/Home.html";
		}
		
		return "/html/Login.html";
	}

}
