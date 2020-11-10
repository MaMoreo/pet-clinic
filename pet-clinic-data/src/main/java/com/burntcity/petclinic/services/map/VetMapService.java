package com.burntcity.petclinic.services.map;

import org.springframework.stereotype.Service;

import com.burntcity.petclinic.model.Speciality;
import com.burntcity.petclinic.model.Vet;
import com.burntcity.petclinic.services.SpecialtyService;
import com.burntcity.petclinic.services.VetService;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {
	private final SpecialtyService service;

	public VetMapService(SpecialtyService service) {
		super();
		this.service = service;
	}

	@Override
	public Vet save(Vet vet) {
		if (vet.getSpecialities().isEmpty()) {
			vet.getSpecialities().forEach(sp -> {
				if (sp.getId() == null) {
					Speciality savedSpeciality = service.save(sp);
					sp.setId(savedSpeciality.getId());
				}
			});
		}
		return super.save(vet);
	}
}
