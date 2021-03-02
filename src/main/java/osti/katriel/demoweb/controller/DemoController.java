package osti.katriel.demoweb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import osti.katriel.demoweb.DemoWebApplication;
import osti.katriel.demoweb.model.Persona;
import osti.katriel.demoweb.repository.IPersonaRepo;

@Controller
public class DemoController {

	private static final Logger log = LoggerFactory.getLogger(DemoWebApplication.class);

	@Autowired
	private IPersonaRepo personaRep;

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			Model model) {

		Persona p = new Persona();
		p.setIdPersona(1);
		p.setNombre("katriel");
		personaRep.save(p);

		model.addAttribute("name", name);
		return "greeting";

	}

	@GetMapping("/listar")
	public String listar(Model model) {

		log.info("-------------------------------");
		for (Persona p : personaRep.findAll()) {
			log.info(p.toString());
		}
		log.info("-------------------------------");
		
		model.addAttribute("name", "Osti Katriel");
		model.addAttribute("personas", personaRep.findAll());
		
		return "greeting";

	}

}
