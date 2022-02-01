package org.iesalixar.servidor.dao;

import java.util.List;

import org.iesalixar.servidor.model.Post;
import org.iesalixar.servidor.model.User;
import org.iesalixar.servidor.utils.dao.GenericDAO;

public interface PostDAO extends GenericDAO<Post> {
	
	public List<Post> searchTitleByUser(final Long userId);

}

