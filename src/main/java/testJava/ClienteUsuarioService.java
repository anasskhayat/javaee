package testJava;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entity.Usuario;
import services.UsuarioServiceRemote;

public class ClienteUsuarioService {

	public static void main(String[] args) {
		 System.out.println("Iniciando llamada al EJB desde el cliente\n");
		  
		 try {
			 
			 Context jndi=new InitialContext();
			 UsuarioServiceRemote usuarioService = (UsuarioServiceRemote)
			jndi.lookup("java:global/jpa/UsuarioServiceImpl!services.UsuarioServiceRemote");
			 
			 List<Usuario> usuarios=usuarioService.listaUsuarios();
			 
			 for (Usuario usuario : usuarios) {
				System.out.println(usuario);
			}
			
			  System.out.println("\nFin llamada al EJB desde el cliente");
			  
		} catch (NamingException  e) {
			e.printStackTrace(System.out) ;
		}
	}

}
