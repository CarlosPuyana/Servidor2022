package org.iesalixar.servidor.hibernate.onetomany.services;

import java.util.List;

import org.iesalixar.servidor.hibernate.onetomany.model.Book;


public interface BookService {

	public void insertNewBook(final Book book);	
	 
	public void updateBook(final Book book);	
	
	public void deleteBook(final Book book);
	
	public Book searchById(final Long bookId);
	
	public List<Book> searchAll();
	
	public Book searchBookByIsbn(final String isbn);
}
