package com.burntcity.petclinic.services.map;

import org.springframework.stereotype.Service;

import com.burntcity.petclinic.model.Owner;
import com.burntcity.petclinic.model.Pet;
import com.burntcity.petclinic.services.OwnerService;
import com.burntcity.petclinic.services.PetService;
import com.burntcity.petclinic.services.PetTypeService;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

	private final PetService petService;
	private final PetTypeService petTypeService;

	public OwnerMapService(PetService petService, PetTypeService petTypeService) {
		super();
		this.petService = petService;
		this.petTypeService = petTypeService;
	}

	@Override
	public Owner findByLastName(String lastName) {
		return null;
	}

	@Override
	public Owner save(Owner owner) {

		if (owner == null) {
			return null;
		}

		if (owner.getPets() != null) {
			owner.getPets().forEach(pet -> {
				if (pet.getPetType() != null) {
					if (pet.getId() == null) {
						pet.setPetType(petTypeService.save(pet.getPetType()));
					}
				} else {
					throw new RuntimeException("Pet Type Required");
				}

				if (pet.getId() == null) {
					Pet savedPet = petService.save(pet);
					pet.setId(savedPet.getId());
				}
			});
		}

		return super.save(owner);
	}

}
