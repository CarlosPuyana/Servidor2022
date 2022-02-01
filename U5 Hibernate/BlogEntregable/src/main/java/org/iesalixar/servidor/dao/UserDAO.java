package org.iesalixar.servidor.dao;

import java.util.List;

import org.iesalixar.servidor.model.User;
import org.iesalixar.servidor.utils.dao.GenericDAO;

public interface UserDAO extends GenericDAO<User> {

	public List<User> searchByEmail(final String username, final String email);
}
