package com.burntcity.petclinic.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.burntcity.petclinic.model.Vet;
import com.burntcity.petclinic.services.VetService;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

	@Override
	public Set<Vet> findAll() {
		return super.findAll();
	}

	@Override
	public Vet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Vet save(Vet object) {
		return super.save(object.getId(), object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public void delete(Vet object) {
		super.delete(object);
	}
}
