package com.burntcity.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.burntcity.petclinic.model.Owner;
import com.burntcity.petclinic.model.Vet;
import com.burntcity.petclinic.services.OwnerService;
import com.burntcity.petclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;

	public DataLoader(OwnerService ownerService, VetService vetService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
	}

	@Override
	public void run(String... args) throws Exception {
		
		Owner owner1 = new Owner();
		owner1.setFirstName("Bruce");
		owner1.setSecondName("Wayne");
		ownerService.save(owner1);

		Owner owner2 = new Owner();
		owner2.setFirstName("Peter");
		owner2.setSecondName("Parker");
		ownerService.save(owner2);
		
		Owner owner3 = new Owner();
		owner3.setFirstName("Steve");
		ownerService.save(owner3);
		
		System.out.println("Loaded Owners....");

		Vet vet1 = new Vet();
		vet1.setFirstName("Sam");
		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setFirstName("Jessie");
		vet2.setSecondName("James");
		vetService.save(vet2);

		System.out.println("Loaded Vets....");
	}
}
