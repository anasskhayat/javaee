package services;

import java.util.List;

import javax.ejb.Remote;

import entity.Usuario;

@Remote
public interface UsuarioServiceRemote {

	public List<Usuario> listaUsuarios();

	public Usuario encontrarUsuarioPorId(Usuario usuario);

	public void InsertUsuario(Usuario usuario);

	public void UpdateUsuario(Usuario usuario);

	public void DeletUsuario(Usuario usuario);

}
