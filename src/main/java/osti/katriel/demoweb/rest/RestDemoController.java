package osti.katriel.demoweb.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import osti.katriel.demoweb.model.Persona;
import osti.katriel.demoweb.repository.IPersonaRepo;

@RestController
public class RestDemoController {

	@Autowired
	private IPersonaRepo personaRepo;

	@GetMapping
	public List<Persona> listar() {

		return personaRepo.findAll();

	}
	
}

//http://localhost:8080/   //  [ { idPersona: 1, nombre: "katriel" } ]