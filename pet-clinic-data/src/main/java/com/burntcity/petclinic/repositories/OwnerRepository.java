package com.burntcity.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.burntcity.petclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

}
