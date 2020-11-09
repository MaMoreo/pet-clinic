package com.burntcity.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.burntcity.petclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
