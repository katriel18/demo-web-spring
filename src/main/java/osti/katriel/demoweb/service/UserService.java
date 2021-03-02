package osti.katriel.demoweb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import osti.katriel.demoweb.model.Usuario;
import osti.katriel.demoweb.repository.IUsuarioRepo;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	IUsuarioRepo usuarioRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Usuario usuario=usuarioRepo.findByNombre(username);
		
		List<GrantedAuthority> roles=new ArrayList<>();
		roles.add(new SimpleGrantedAuthority("ADMIN"));
		
		UserDetails userDetails=new User(usuario.getNombre(),usuario.getClave(),roles);
		
		return userDetails;
		
	}

}
