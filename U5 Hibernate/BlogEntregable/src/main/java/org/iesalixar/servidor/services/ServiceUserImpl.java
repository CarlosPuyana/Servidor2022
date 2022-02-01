package org.iesalixar.servidor.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.iesalixar.servidor.dao.UserDAO;
import org.iesalixar.servidor.dao.UserDAOImpl;
import org.iesalixar.servidor.model.Comments;
import org.iesalixar.servidor.model.User;

public class ServiceUserImpl implements ServiceUser {

	private UserDAO dao;

	public ServiceUserImpl(final Session session) {

		this.dao = new UserDAOImpl(session);
	}

	@Override
	public void insertNewUser(User user) {

		if (user != null && user.getId() == null) {

			dao.insert(user);
		}

	}

	@Override
	public void updateUser(User user) {

		if (user != null && user.getId() == null) {

			dao.update(user);
		}
	}

	@Override
	public void deleteUser(User user) {

		if (user != null && user.getId() == null) {

			dao.delete(user);
		}
	}

	@Override
	public User searchById(Long userId) {
		User user = null;

		if (user != null) {

			user = dao.searchById(userId);
		}

		return user;
	}

	@Override
	public List<User> searchAll() {
		List<User> userList = new ArrayList<User>();

		userList = dao.searchAll();

		return userList;
	}

	@Override
	public List<User> searchByName(String email, String name) {
		 List<User> commentsList = new ArrayList<User>();
	        if (email!= null || name!=null) {
	            commentsList = dao.searchByEmail(name, name);
	        }
	        return commentsList;
	}
	
}
