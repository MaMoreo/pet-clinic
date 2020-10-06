package com.burntcity.petclinic.services;

import java.util.Set;

import javax.persistence.Id;

public interface CrudService<T, ID> {

	Set<T> findAll();

	T findById(Id id);

	T save(T object);
	
	void delete(T object);
	
	void deleteById(Id id);
}
