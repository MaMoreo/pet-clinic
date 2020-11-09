package com.burntcity.petclinic.services.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.burntcity.petclinic.model.Owner;
import com.burntcity.petclinic.repositories.OwnerRepository;
import com.burntcity.petclinic.services.OwnerService;

@Service
@Profile("springdatajpa")
public class OwnerSDJPaService implements OwnerService {

	private final OwnerRepository ownerRepository;

	public OwnerSDJPaService(OwnerRepository ownerRepository) {
		super();
		this.ownerRepository = ownerRepository;
	}

	@Override
	public Set<Owner> findAll() {
		Set<Owner> allOwners = new HashSet<>();
		ownerRepository.findAll().forEach(allOwners::add);
		return allOwners;
	}

	@Override
	public Owner findById(Long id) {
		Optional<Owner> owner = ownerRepository.findById(id);
		return owner.orElse(null);
	}

	@Override
	public Owner save(Owner owner) {
		return ownerRepository.save(owner);
	}

	@Override
	public void delete(Owner owner) {
		ownerRepository.delete(owner);
	}

	@Override
	public void deleteById(Long id) {
		ownerRepository.deleteById(id);
	}

	@Override
	public Owner findByLastName(String lastName) {
		return ownerRepository.findByLastName(lastName);
	}
}
