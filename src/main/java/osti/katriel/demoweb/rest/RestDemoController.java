package osti.katriel.demoweb.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import osti.katriel.demoweb.model.Persona;
import osti.katriel.demoweb.repository.IPersonaRepo;

@RestController
@RequestMapping("/personas")
public class RestDemoController {

	@Autowired
	private IPersonaRepo personaRepo;

	@GetMapping
	public List<Persona> listar() {

		return personaRepo.findAll();

	}
	
	@PostMapping
	public void insertar(@RequestBody Persona persona) {
		
		personaRepo.save(persona);
		
	}
	
	@PutMapping
	public void modificar(@RequestBody Persona persona) {
		
		personaRepo.save(persona);
		
	}
	
	@DeleteMapping(value="/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		
		personaRepo.deleteById(id);
		
	}
	
}

//  http://localhost:8080/personas   //  [ { idPersona: 1, nombre: "katriel" } ]