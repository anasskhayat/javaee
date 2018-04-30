package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {
	
	@PersistenceContext(unitName="PersonaPU")
	EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> finAllUsuario() {
		
		return em.createNamedQuery("Usuario.findAll").getResultList() ;
	}

	@Override
	public Usuario findByUsuarioId(Usuario usuario) {
		return em.find(Usuario.class, usuario.getIdUsuario());
	}

	@Override
	public void InsertUsuario(Usuario usuario) {
		em.persist(usuario);
		
	}

	@Override
	public void UpdateUsuario(Usuario usuario) {
	      em.merge(usuario);
		
	}

	@Override
	public void DeletUsuario(Usuario usuario) {
		  em.merge(usuario);
		  em.remove(usuario);
		
	}

}
