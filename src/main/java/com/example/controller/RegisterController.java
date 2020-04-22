package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import com.example.dao.PetDaoImpl;
import com.example.model.Pet;

public class RegisterController {

	
	public static String Register(HttpServletRequest request) {
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		
		Pet pet = new Pet();
		pet.setName(name);
		pet.setType(type);
		System.out.println(pet);
		PetDaoImpl petDaoImpl = new PetDaoImpl();
		petDaoImpl.insertPet(pet);
		System.out.println("dfsdfsdf");
		return "/html/Login.html";
	}
}
