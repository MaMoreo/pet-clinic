package com.burntcity.petclinic.controllers;

import static org.mockito.Mockito.verifyZeroInteractions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import com.burntcity.petclinic.services.OwnerService;

@ExtendWith(MockitoExtension.class) 
class OwnerControllerTest {

	@Mock
	OwnerService service;
	@Mock
	Model model;
	
	@InjectMocks
	OwnerController controller;
	
	@BeforeEach
	void setUp() throws Exception {
		controller = new OwnerController(service);
	}

	@Test
	void testIndex() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		mockMvc.perform(MockMvcRequestBuilders.get("/owners/"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.view().name("owners/index.html"));
		//.andExpect(MockMvcResultMatchers.model().attribute("owners", Matchers.hasSize(0)));
	}

	@Test
	void testFindOwners() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		mockMvc.perform(MockMvcRequestBuilders.get("/owners/find"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.view().name("notimplemented.html"));
		
		verifyZeroInteractions(service);
	}

}
