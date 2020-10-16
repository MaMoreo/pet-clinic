package com.burntcity.petclinic.services.map;

import org.springframework.stereotype.Service;

import com.burntcity.petclinic.model.Pet;
import com.burntcity.petclinic.services.PetService;

@Service
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {

}
