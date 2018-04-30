package services;

import java.util.List;

import javax.ejb.Local;

import entity.Persona;

@Local
public interface ServicePerson {
		
		public List<Persona> ListarPersonas();
		public Persona encontrarPersonaPorId(Persona persona);
		public Persona findPersonByEmail(Persona persona);
		public void insertPersona (Persona persona);
		public void updatePersona (Persona persona);
		public void deletPersona (Persona persona);
		

	}


