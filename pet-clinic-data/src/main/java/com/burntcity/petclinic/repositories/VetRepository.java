package com.burntcity.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.burntcity.petclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {

}
