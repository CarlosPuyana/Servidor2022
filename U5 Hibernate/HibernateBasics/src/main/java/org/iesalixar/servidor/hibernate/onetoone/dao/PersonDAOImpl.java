package org.iesalixar.servidor.hibernate.onetoone.dao;

import java.util.List;

import org.hibernate.Session;
import org.iesalixar.servidor.hibernate.onetoone.model.Person;
import org.iesalixar.servidor.hibernate.utils.dao.GenericDAOImpl;


public class PersonDAOImpl extends GenericDAOImpl<Person> implements PersonDAO {

	public PersonDAOImpl(Session session) {
		super(session);
		// TODO Auto-generated constructor stub
	}


	private Session session;
	
	
	@Override
	public List<Person> searchByFirstAndLastName(final String firstName, final String lastName) {

		// Compruebo que la conexión esté activa
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Recupero las personas con esos datos
		final List<Person> personList = session.createQuery("FROM persons WHERE fistName =" + firstName + " AND lastName = " 
					+ lastName).list();

		return personList;
	}

}
