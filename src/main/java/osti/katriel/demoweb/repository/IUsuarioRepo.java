package osti.katriel.demoweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import osti.katriel.demoweb.model.Usuario;

public interface IUsuarioRepo extends JpaRepository<Usuario, Integer>{

	Usuario findByNombre(String nombre);
}
