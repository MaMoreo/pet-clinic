package com.burntcity.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.burntcity.petclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}
