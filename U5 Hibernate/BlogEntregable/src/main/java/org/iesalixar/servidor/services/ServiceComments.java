package org.iesalixar.servidor.services;

import java.util.List;

import org.iesalixar.servidor.model.Comments;

public interface ServiceComments {

	public void insertNewComment(final Comments comment);

    public void updateComment(final Comments comment);

    public void deleteComment(final Comments comment);

    public Comments searchById(final Long commentId);

    public List<Comments> searchAll();

    public List<Comments> searchByName(String name);
	
}
