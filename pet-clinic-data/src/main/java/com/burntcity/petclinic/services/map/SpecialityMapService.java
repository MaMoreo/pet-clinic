package com.burntcity.petclinic.services.map;

import org.springframework.stereotype.Service;

import com.burntcity.petclinic.model.Speciality;
import com.burntcity.petclinic.services.SpecialtiesService;

@Service
public class SpecialityMapService extends AbstractMapService<Speciality, Long> implements SpecialtiesService {

}
