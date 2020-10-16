package com.burntcity.petclinic.services.map;

import org.springframework.stereotype.Service;

import com.burntcity.petclinic.model.PetType;
import com.burntcity.petclinic.services.CrudService;
import com.burntcity.petclinic.services.PetTypeService;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {

}
