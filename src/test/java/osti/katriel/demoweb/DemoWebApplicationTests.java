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
		
		//no puede haber dos nombres de usuario igual - no loguea (ni con contraseñas iguales, ni con contraseñas diferentes)
		//si puedes haber dos contraseñas igual pero diferente usuario
		usarioEnviado.setId(1);
		usarioEnviado.setNombre("osti");					//osti //katriel
		usarioEnviado.setClave(encoder.encode("1234"));	//1234 //1234
		
		Usuario usarioRetornado=usuarioRepo.save(usarioEnviado);
		
		//assertTrue(usarioRetornado.getClave().equalsIgnoreCase(usarioEnviado.getNombre()));
		assertTrue(usarioRetornado.getClave().equalsIgnoreCase(usarioEnviado.getClave()));
		
	
	}

}
