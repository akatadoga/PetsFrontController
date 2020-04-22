package com.example.dao;

import com.example.model.Pet;

public interface PetDao {
	
	public int insertPet(Pet p);
	public Pet selectPetByName(String name);
	public int updatePet(Pet p);

}
