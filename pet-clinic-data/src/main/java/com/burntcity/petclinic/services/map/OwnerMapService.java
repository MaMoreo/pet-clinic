package com.burntcity.petclinic.services.map;

import org.springframework.stereotype.Service;

import com.burntcity.petclinic.model.Owner;
import com.burntcity.petclinic.services.OwnerService;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

	@Override
	public Owner findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

}
