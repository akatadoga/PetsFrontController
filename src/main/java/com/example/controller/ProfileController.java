package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import com.example.dao.PetDaoImpl;
import com.example.model.Pet;

public class ProfileController {

	public static String Update(HttpServletRequest request) {
		Pet pet = (Pet)request.getSession().getAttribute("Pet");
		//getting the attribute from the session that was set upon 
		//login in LoginController
		
		String type = request.getParameter("type");
		pet.setType(type);
		
		PetDaoImpl petDaoImpl = new PetDaoImpl();
		petDaoImpl.updatePet(pet);
		
		return "/html/Home.html";
	}
}
