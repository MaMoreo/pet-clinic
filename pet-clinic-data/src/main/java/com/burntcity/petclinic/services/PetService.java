package com.burntcity.petclinic.services;

import java.util.Set;

import com.burntcity.petclinic.model.Pet;

public interface PetService {

	Pet findById(Long id); 
	Pet save(Pet pet);
	Set<Pet> findAll();
}
