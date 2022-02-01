package org.iesalixar.servidor.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.iesalixar.servidor.dao.CommentsDAO;
import org.iesalixar.servidor.dao.CommentsDAOImpl;
import org.iesalixar.servidor.model.Comments;

public class ServiceCommentsImpl implements ServiceComments {

	private CommentsDAO dao;

	public ServiceCommentsImpl(final Session session) {

		this.dao = new CommentsDAOImpl(session);
	}

	@Override
	public void insertNewComment(Comments comment) {

		if (comment != null && comment.getId() == null) {

			dao.insert(comment);
		}

	}

	@Override
	public void updateComment(Comments comment) {

		if (comment != null && comment.getId() == null) {

			dao.update(comment);
		}
	}

	@Override
	public void deleteComment(Comments comment) {

		if (comment != null && comment.getId() == null) {

			dao.delete(comment);
		}
	}

	@Override
	public Comments searchById(Long commentId) {
		Comments comment = null;

		if (comment != null) {

			comment = dao.searchById(commentId);
		}

		return comment;
	}

	@Override
	public List<Comments> searchAll() {
		List<Comments> commentsList = new ArrayList<Comments>();

		commentsList = dao.searchAll();

		return commentsList;
	}

	@Override
	public List<Comments> searchByName(String name) {
		  List<Comments> commentsList = new ArrayList<Comments>();
	        if (name!=null) {
	            commentsList = dao.searchByPalabra(name);
	        }
	        return commentsList;
	}

}
