package dao;

import java.util.List;

import entity.Usuario;

public interface UsuarioDao {
	
	public List<Usuario> finAllUsuario();
	
	public Usuario findByUsuarioId(Usuario usuario);
	
	public void  InsertUsuario(Usuario usuario);
	
	public void  UpdateUsuario(Usuario usuario);
	
	public void  DeletUsuario(Usuario usuario);

}
