package com.burntcity.petclinic.services.map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.burntcity.petclinic.model.Visit;
import com.burntcity.petclinic.services.VisitService;

@Service
@Profile({"default", "map"})
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService{

	@Override
	public Visit save(Visit visit) {
		if (visit == null || visit.getPet() == null || visit.getPet().getOwner() == null ||
				visit.getPet().getOwner().getId() == null ) {
			throw new RuntimeException("Invalid visit");
		}
		return super.save(visit);
	}
}
