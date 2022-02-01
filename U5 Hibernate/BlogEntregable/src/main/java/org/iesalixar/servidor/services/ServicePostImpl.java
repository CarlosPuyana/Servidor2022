package org.iesalixar.servidor.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.iesalixar.servidor.dao.PostDAO;
import org.iesalixar.servidor.dao.PostDAOImpl;
import org.iesalixar.servidor.model.Post;

public class ServicePostImpl implements ServicePost {

	private PostDAO dao;

	public ServicePostImpl(final Session session) {

		this.dao = new PostDAOImpl(session);
	}

	@Override
	public void insertNewPost(Post post) {

		if (post != null && post.getId() == null) {

			dao.insert(post);
		}

	}

	@Override
	public void updatePost(Post post) {

		if (post != null && post.getId() == null) {

			dao.update(post);
		}
	}

	@Override
	public void deletePost(Post post) {

		if (post != null && post.getId() == null) {

			dao.delete(post);
		}
	}

	@Override
	public Post searchById(Long postId) {
		Post comment = null;

		if (comment != null) {

			comment = dao.searchById(postId);
		}

		return comment;
	}

	@Override
	public List<Post> searchAll() {
		List<Post> postList = new ArrayList<Post>();

		postList = dao.searchAll();

		return postList;
	}

	@Override
	public List<Post> searchByName(String name) {
		 
	        
	        return null;
	}
	
}
