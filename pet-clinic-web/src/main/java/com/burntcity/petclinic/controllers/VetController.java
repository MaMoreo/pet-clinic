package com.burntcity.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.burntcity.petclinic.services.VetService;

@Controller
@RequestMapping("vets")
public class VetController {

	private final VetService service;

	public VetController(VetService service) {
		super();
		this.service = service;
	}

	@RequestMapping({ "", "/", "index", "index.html" })
	public String index(Model model) {
		model.addAttribute("vets", service.findAll());
		return "vets/index.html";
	}
}
