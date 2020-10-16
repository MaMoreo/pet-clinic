package com.burntcity.petclinic.services.map;

import org.springframework.stereotype.Service;

import com.burntcity.petclinic.model.Vet;
import com.burntcity.petclinic.services.VetService;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

}
