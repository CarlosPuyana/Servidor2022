package org.iesalixar.servidor.dao;

import org.iesalixar.servidor.model.Usuario;

public interface DAOUsuario {

	public Usuario getUsuario(String email);
	public boolean registerUsuario(Usuario usuario);
	public boolean updateContrasena(Usuario usuario);
	
	
	
}
