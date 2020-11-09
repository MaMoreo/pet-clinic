package com.burntcity.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.burntcity.petclinic.model.Speciality;

public interface SpecialTyRepository extends CrudRepository<Speciality, Long> {

}
