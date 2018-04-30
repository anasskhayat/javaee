package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.ejb.embeddable.EJBContainer;

import org.junit.Before;
import org.junit.Test;

import entity.Persona;
import entity.Usuario;
import services.ServicePerson;
import services.UsuarioService;

public class PersonaServiceTest {

	private ServicePerson servicePerson;
	private UsuarioService usuarioService;
	
	EJBContainer contenedor;
	
	@Before
    public void setUp() throws Exception {
		
		contenedor=EJBContainer.createEJBContainer();
		 System.out.println("Abriendo contenedor embebido");
		 servicePerson= (ServicePerson) contenedor.getContext().lookup("java:global/classes/PersonaServiceImpl!jpa.services.PersonaService");
		 usuarioService= (UsuarioService) contenedor.getContext().lookup("java:global/classes/PersonaServiceImpl!jpa.services.UsuarioService");
		 
	}
	   @Test
	    public void testEJB() {
	        this.testEJBServicePerson();
	        this.testEJBUsuarioService();
	    }
	   
	private void testEJBServicePerson() {
		System.out.println("Iniciando test EJB PersonaService");
		assertTrue(servicePerson != null);
		
		assertEquals(2, servicePerson.ListarPersonas().size());
        System.out.println("El no. de personas es igual a:" + servicePerson.ListarPersonas().size());

        this.desplegarPersonas(servicePerson.ListarPersonas());
        System.out.println("Fin test EJB PersonaService");
		
	}
	 private void testEJBUsuarioService() {
	        System.out.println("Iniciando test EJB UsuarioService");
	        assertTrue(usuarioService != null);

	        assertEquals(1, usuarioService.listaUsuarios().size());

	        System.out.println("El no. de usuarios es igual a:" + usuarioService.listaUsuarios().size());

	        this.desplegarUsuarios(usuarioService.listaUsuarios());
	        System.out.println("Fin test EJB UsuarioService");
	    }

	    private void desplegarUsuarios(List<Usuario> usuarios) {
	        for (Usuario u : usuarios) {
	            System.out.println(u);
	        }
	    }

	    private void desplegarPersonas(List<Persona> personas) {

	        for (Persona p : personas) {
	            System.out.println(p);
	        }
	   
	    }
}
