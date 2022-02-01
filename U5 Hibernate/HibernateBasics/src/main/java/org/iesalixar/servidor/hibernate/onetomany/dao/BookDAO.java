package org.iesalixar.servidor.hibernate.onetomany.dao;

import org.iesalixar.servidor.hibernate.onetomany.model.Book;
import org.iesalixar.servidor.hibernate.utils.dao.GenericDAO;

public interface BookDAO extends GenericDAO<Book> {

	public Book searchByIsbn(final String isbn);
	
}
