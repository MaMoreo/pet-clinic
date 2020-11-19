package com.burntcity.petclinic.services.springdatajpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.burntcity.petclinic.model.Owner;
import com.burntcity.petclinic.repositories.OwnerRepository;

@ExtendWith(MockitoExtension.class)   // this will call MockitoAnnotations.initMocks(this);
class OwnerSDJPaServiceTest {

	@Mock
	OwnerRepository ownerRepository;
	
	@InjectMocks
	OwnerSDJPaService ownerService;
	
	@BeforeEach
	void setUp() throws Exception {
	//	ownerService = new OwnerSDJPaService(ownerRepository);    // This is done with the @InjectMocks
	}

	@Test
	void testFindAll() {
		fail("Not yet implemented");
	}

	@Test
	void testFindById() {
		fail("Not yet implemented");
	}

	@Test
	void testSave() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteById() {
		fail("Not yet implemented");
	}

	@Test
	void testFindByLastName() {
		Owner bruce = Owner.builder().id(1l).lastName("Wayne").build();
		when(ownerRepository.findByLastName(any())).thenReturn(bruce);
		Owner ownerFound = ownerService.findByLastName("Wayne");
		
		assertEquals("Wayne", bruce.getLastName());
		// default is 1 times
		verify(ownerService.findByLastName(any())); 
	}
}
