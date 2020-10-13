package com.burntcity.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.burntcity.petclinic.services.OwnerService;

@Controller
@RequestMapping("owners")
public class OwnerController {

	private final OwnerService service;
	
	
	public OwnerController(OwnerService service) {
		this.service = service;
	}

	@RequestMapping({ "", "/", "index", "index.html" })
	public String index(Model model) {

		model.addAttribute("owners", service.findAll());
		
		return "owners/index.html";
	}
}
