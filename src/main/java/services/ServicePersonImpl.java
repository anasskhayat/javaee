package services;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.PersonaDao;
import entity.Persona;

@Stateless
public class ServicePersonImpl implements ServicePerson,ServicePersonRemote{

	@Inject
	private PersonaDao personaDao;
	
    @Resource
    private SessionContext context;


	@Override
	public List<Persona> ListarPersonas() {
		// TODO Auto-generated method stub
		return personaDao.findallPersonas();
	}

	@Override
	public Persona encontrarPersonaPorId(Persona persona) {
		// TODO Auto-generated method stub
		return personaDao.findPersonaById(persona);
	}
	
	@Override
	public Persona findPersonByEmail(Persona persona) {

		return personaDao.findPersonByEmail(persona);
	}

	@Override
	public void insertPersona(Persona persona) {
		personaDao.insertPersona(persona);
		
	}

	@Override
	public void updatePersona(Persona persona) {
		try {
			personaDao.updatePersona(persona);
		} catch (Throwable t) {
			
			context.setRollbackOnly();
			t.printStackTrace(System.out);
		}
	
		
	}

	@Override
	public void deletPersona(Persona persona) {
		personaDao.deletPersona(persona);
		
	}







}
