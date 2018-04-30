package dao;

import java.util.List;

import entity.Persona;

public interface PersonaDao {
	
	public List<Persona> findallPersonas();
	public Persona findPersonaById(Persona persona);
	public Persona findPersonByEmail(Persona persona);
	public void insertPersona (Persona persona);
	public void updatePersona (Persona persona);
	public void deletPersona (Persona persona);
	

}
