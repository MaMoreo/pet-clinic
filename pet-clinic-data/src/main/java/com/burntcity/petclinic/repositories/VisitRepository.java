package com.burntcity.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;

import com.burntcity.petclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {

}
