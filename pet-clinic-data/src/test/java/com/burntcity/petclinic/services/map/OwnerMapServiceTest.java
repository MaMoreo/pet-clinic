package com.burntcity.petclinic.services.map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.burntcity.petclinic.model.Owner;

class OwnerMapServiceTest {

	/*  We do not need to mock this, they are just HashMaps
		PetService petService;
		PetTypeService petTypeService;
	*/
	OwnerMapService ownerMapService;
	private final long ownerId = 1L;
	private final String lastName = "Wayne";
	
	@BeforeEach
	void setUp() throws Exception {
		ownerMapService = new OwnerMapService(new PetMapService(), new PetTypeMapService());
		ownerMapService.save(Owner.builder().id(ownerId).lastName(lastName).build());
	}

	@Test
	void testFindAll() {
		assertEquals(ownerId, ownerMapService.findAll().size()); 	
	}
	
	@Test
	void testFindByLastName() {
		Owner bruce = ownerMapService.findByLastName(lastName);
		assertNotNull(bruce);
		assertEquals(lastName, bruce.getLastName());
	}
	
	@Test
	void testFindByLastNameNoFound() {
		Owner bruce = ownerMapService.findByLastName("Barner");
		assertNull(bruce);
	}

	@Test
	void testExistingId() {
		long id = 2L;
		Owner owner2 = Owner.builder().id(id).build();
		Owner savedOwner2 = ownerMapService.save(owner2);
		assertEquals(id, savedOwner2.getId());
	}

	
	@Test
	void saveNoId() {
		Owner savedOwner = ownerMapService.save(Owner.builder().build());
		assertNotNull(savedOwner);
		assertNotNull(savedOwner.getId());
	}
	
	@Test
	void testFindById() {
		assertEquals(ownerId, ownerMapService.findById(ownerId).getId());
	}

	@Test
	void testDeleteById() {
		assertEquals(1 , ownerMapService.findAll().size());
		ownerMapService.deleteById(ownerId);
		assertEquals(0 , ownerMapService.findAll().size());
	}

	@Test
	void testDelete() {
		assertEquals(1 , ownerMapService.findAll().size());
		ownerMapService.delete(ownerMapService.findById(ownerId));
		assertEquals(0 , ownerMapService.findAll().size());
	}

}
