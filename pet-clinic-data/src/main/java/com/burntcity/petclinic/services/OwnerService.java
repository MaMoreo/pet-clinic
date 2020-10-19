package com.burntcity.petclinic.services;

import com.burntcity.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

	Owner findByLastName(String lastName);
	
	
}
