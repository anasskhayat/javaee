package services;

import java.util.List;

import javax.inject.Inject;

import dao.UsuarioDao;
import entity.Usuario;

public class UsuarioServiceImpl implements UsuarioService, UsuarioServiceRemote{

	@Inject
	private UsuarioDao usuarioDao;
	
	@Override
	public List<Usuario> listaUsuarios() {
		// TODO Auto-generated method stub
		return usuarioDao.finAllUsuario() ;
	}

	@Override
	public Usuario encontrarUsuarioPorId(Usuario usuario) {
		// TODO Auto-generated method stub
		return usuarioDao.findByUsuarioId(usuario);
	}

	@Override
	public void InsertUsuario(Usuario usuario) {
		usuarioDao.InsertUsuario(usuario);
		
	}

	@Override
	public void UpdateUsuario(Usuario usuario) {
		usuarioDao.UpdateUsuario(usuario);
		
	}

	@Override
	public void DeletUsuario(Usuario usuario) {
		usuarioDao.DeletUsuario(usuario);
		
	}

}
