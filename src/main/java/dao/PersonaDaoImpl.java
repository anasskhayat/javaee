package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entity.Persona;

@Stateless
public class PersonaDaoImpl implements PersonaDao {
	
	@PersistenceContext(unitName="PersonaPU")
	EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Persona> findallPersonas() {

		return em.createNamedQuery("Persona.findAll").getResultList();
	}

	@Override
	public Persona findPersonaById(Persona persona) {

		return em.find(Persona.class, persona.getIdPersona());
	}

	@Override
	public Persona findPersonByEmail(Persona persona) {
	     Query query=em.createQuery("from p Person where p.email=: email");
	     query.setParameter("email", persona.getEmail());
	     
		return (Persona) query.getSingleResult();
	}

	@Override
	public void insertPersona(Persona persona) {
	   em.persist(persona);
		
	}

	@Override
	public void updatePersona(Persona persona) {
		em.merge(persona);
		
	}

	@Override
	public void deletPersona(Persona persona) {
		em.merge(persona);
		em.remove(persona);
		
	}
	

}
