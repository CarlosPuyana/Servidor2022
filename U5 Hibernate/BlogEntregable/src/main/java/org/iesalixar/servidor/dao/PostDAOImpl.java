package org.iesalixar.servidor.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.iesalixar.servidor.model.Comments;
import org.iesalixar.servidor.model.Post;
import org.iesalixar.servidor.model.User;
import org.iesalixar.servidor.utils.dao.GenericDAOImpl;

public class PostDAOImpl extends GenericDAOImpl<Post> implements PostDAO {

	private Session session;
	
	public PostDAOImpl(Session session) {
		super(session);
		this.session = session;
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Post> searchTitleByUser(Long userId) {
		// Compruebo que la conexion está activa
				if (!session.getTransaction().isActive()) {
					session.getTransaction().begin();
				}

				
				
				return null;
	}
	
	

}
