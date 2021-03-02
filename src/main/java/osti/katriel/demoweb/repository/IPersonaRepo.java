package osti.katriel.demoweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import osti.katriel.demoweb.model.Persona;

public interface IPersonaRepo extends JpaRepository<Persona, Integer>{

}
