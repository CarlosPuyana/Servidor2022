package org.iesalixar.servidor.hibernate.onetomany.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.iesalixar.servidor.hibernate.onetomany.dao.BookDAO;
import org.iesalixar.servidor.hibernate.onetomany.dao.BookDAOImpl;
import org.iesalixar.servidor.hibernate.onetomany.model.Book;

public class BookServiceImpl implements BookService {

	// El servicio encapsulará el uso del DAO
	// y añadirá lógica de negocio necesaria
	private BookDAO bookDao;

	public BookServiceImpl(final Session session) {
		this.bookDao = new BookDAOImpl(session);
	}

	@Override
	public void insertNewBook(final Book book) {

		// Hago comprobaciones (pueden cambiar dependiendo
		// de la aplicación para varios usos del mismo DAO
		if (book != null && book.getId() == null) {

			bookDao.insert(book);
		}

	}

	@Override
	public void updateBook(final Book book) {

		// Comprobamos que no es nulo y que ya existe
		if (book != null && book.getId() != null) {

			bookDao.update(book);

		}

	}

	@Override
	public void deleteBook(final Book book) {

		// Comprobamos que no es nulo y que ya existe
		if (book != null && book.getId() != null) {

			bookDao.delete(book);

		}

	}

	@Override
	public Book searchById(final Long bookId) {

		Book book = null;

		if (bookId != null) {
			bookDao.searchById(bookId);
		}

		return book;
	}

	@Override
	public List<Book> searchAll() {

		List<Book> bookList = new ArrayList<Book>();

		bookList = bookDao.searchAll();

		return bookList;
	}

	@Override
	public Book searchBookByIsbn(final String isbn) {

		Book book = null;

		if (isbn != null) {
			book = bookDao.searchByIsbn(isbn);
		}

		return book;
	}

}
