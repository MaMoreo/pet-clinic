package com.burntcity.petclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.burntcity.petclinic.model.Owner;
import com.burntcity.petclinic.model.Pet;
import com.burntcity.petclinic.model.PetType;
import com.burntcity.petclinic.model.Speciality;
import com.burntcity.petclinic.model.Vet;
import com.burntcity.petclinic.model.Visit;
import com.burntcity.petclinic.services.OwnerService;
import com.burntcity.petclinic.services.PetTypeService;
import com.burntcity.petclinic.services.SpecialtyService;
import com.burntcity.petclinic.services.VetService;
import com.burntcity.petclinic.services.VisitService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialtyService specialitiesService;
	private final VisitService visitService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
			SpecialtyService specialitiesService, VisitService visitService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialitiesService = specialitiesService;
		this.visitService = visitService;
	}

	@Override
	public void run(String... args) throws Exception {

		int count = petTypeService.findAll().size();

		if (count == 0)
			loadData();

	}

	private void loadData() {
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogType = petTypeService.save(dog); // save add's the ID !!

		Speciality radiology = new Speciality();
		radiology.setDescription("radiology");
		Speciality savedRadioly = specialitiesService.save(radiology);

		Speciality surgery = new Speciality();
		surgery.setDescription("surgery");
		Speciality savedSurgery = specialitiesService.save(surgery);

		Speciality dentistry = new Speciality();
		dentistry.setDescription("dentistry");
		Speciality savedDentistry = specialitiesService.save(dentistry);

		Owner batman = new Owner();
		batman.setFirstName("Bruce");
		batman.setLastName("Wayne");
		batman.setAddress("Wayne Manor");
		batman.setCity("Gotham City");
		batman.setTelephone("000-Bat-Signal");

		Pet batDog = new Pet();
		batDog.setPetType(savedDogType);
		batDog.setOwner(batman);
		batDog.setBirthDate(LocalDate.now());
		batDog.setName("BatDog");

		batman.getPets().add(batDog);

		ownerService.save(batman);

		Visit visitForBatDog = new Visit();
		visitForBatDog.setPet(batDog);
		visitForBatDog.setDate(LocalDate.now());
		visitForBatDog.setDescription("Ate too much");
		visitService.save(visitForBatDog);
		
		/*********************************************/
		PetType cat = new PetType();
		cat.setName("Cat");
		PetType savedCatPetType = petTypeService.save(cat);

		Owner spiderman = new Owner();
		spiderman.setFirstName("Peter");
		spiderman.setLastName("Parker");
		spiderman.setAddress("May's House");
		spiderman.setCity("New York");
		spiderman.setTelephone("123-Spider-Sense");

		Pet spiderCat = new Pet();
		spiderCat.setPetType(savedCatPetType);
		spiderCat.setOwner(spiderman);
		spiderCat.setBirthDate(LocalDate.now());
		spiderCat.setName("Felicia");

		spiderman.getPets().add(spiderCat);
		ownerService.save(spiderman);

		/*********************************************/
		Owner owner3 = new Owner();
		owner3.setFirstName("Steve");
		owner3.setLastName("Rogers");
		ownerService.save(owner3);

		System.out.println("Loaded Owners....");

		Vet vet1 = new Vet();
		vet1.setFirstName("Sam");
		vetService.save(vet1);
		vet1.getSpecialities().add(savedRadioly);

		Vet vet2 = new Vet();
		vet2.setFirstName("Jessie");
		vet2.setLastName("James");
		vetService.save(vet2);
		vet2.getSpecialities().add(savedSurgery);

		System.out.println("Loaded Vets....");

		System.out.println("Loaded PetTypes....");
	}
}
