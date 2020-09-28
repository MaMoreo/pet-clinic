package com.burntcity.petclinic.services;

import java.util.Set;

import com.burntcity.petclinic.model.Vet;

public interface VetService {

	Vet findById(Long id); 
	Vet save(Vet vet);
	Set<Vet> findAll();
}
