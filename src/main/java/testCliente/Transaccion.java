package testCliente;



import javax.naming.Context;
import javax.naming.InitialContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import entity.Persona;
import services.ServicePersonRemote;

public class Transaccion {
	
	static Logger log=LogManager.getRootLogger();
	
	public static void main(String[] args) throws Exception {
		
		Context jndi=new InitialContext();
		ServicePersonRemote personService=(ServicePersonRemote) jndi.lookup("java:global/jpa/ServicePersonImpl!services.PersonaServiceRemote");	
        log.debug("Iniciando prueba Manejo Transaccional PersonaService");
        
      //Buscamos un objeto persona 
        Persona persona1=personService.encontrarPersonaPorId(new Persona(1));
        
      //Cambiamos la persona
        persona1.setApellidoMaterno("\"Cambio con error....................................................................");
       
        //persona1.setApellidoMaterno("Cambio sin errror")

        personService.updatePersona(persona1);

        log.debug("Objeto modificado:" + persona1);
        log.debug("Fin prueba EJB PersonaService");
        
	}

}
