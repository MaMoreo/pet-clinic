package com.burntcity.petclinic.services.map;

import java.util.Set;

import com.burntcity.petclinic.model.Pet;
import com.burntcity.petclinic.services.PetService;

public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {

	@Override
	public Set<Pet> findAll() {
		return super.findAll();
	}

	@Override
	public Pet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Pet save(Pet object) {
		return  super.save(object.getId(), object);
	}

	@Override
	public void deleteById(Long id) {
		 super.deleteById(id);
	}

	@Override
	public void delete(Pet object) {
		 super.delete(object);
	}
}
