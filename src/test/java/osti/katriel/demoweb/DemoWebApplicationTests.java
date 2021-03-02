package osti.katriel.demoweb;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import osti.katriel.demoweb.model.Usuario;
import osti.katriel.demoweb.repository.IUsuarioRepo;

@SpringBootTest
class DemoWebApplicationTests {
	
	@Autowired
	private IUsuarioRepo usuarioRepo;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Test
	public void crearUsuarioTest() {
		
		Usuario usarioEnviado=new Usuario();
		
		usarioEnviado.setId(3);
		usarioEnviado.setNombre("osti");					//osti
		usarioEnviado.setClave(encoder.encode("katriel"));	//katriel
		
		Usuario usarioRetornado=usuarioRepo.save(usarioEnviado);
		
		//assertTrue(usarioRetornado.getClave().equalsIgnoreCase(usarioEnviado.getNombre()));
		assertTrue(usarioRetornado.getClave().equalsIgnoreCase(usarioEnviado.getClave()));
		
	
	}

}
