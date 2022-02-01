package org.iesalixar.servidor.hibernate.onetoone;

import java.util.Calendar;

import org.hibernate.Session;
import org.iesalixar.servidor.hibernate.onetoone.dao.PassportDAO;
import org.iesalixar.servidor.hibernate.onetoone.dao.PassportDAOImpl;
import org.iesalixar.servidor.hibernate.onetoone.dao.PersonDAO;
import org.iesalixar.servidor.hibernate.onetoone.dao.PersonDAOImpl;
import org.iesalixar.servidor.hibernate.onetoone.model.Passport;
import org.iesalixar.servidor.hibernate.onetoone.model.Person;
import org.iesalixar.servidor.hibernate.utils.HibernateUtils;

public class MainOneToOne {

	public static void main(String[] args) {

		// Para trabajar con las fechas
		Calendar calendar = Calendar.getInstance();

		// Obtengo la sesión
		final Session session = HibernateUtils.getSessionFactory().openSession();

		// Obtengo los DAOs
		PassportDAO passportDao = new PassportDAOImpl(session);
		PersonDAO personDAO = new PersonDAOImpl(session);

		// Creo la persona
		Person person = new Person();
		person.setFirstName("Pepe");
		person.setLastName("Perez");
		calendar.set(Calendar.YEAR, 1976);
		calendar.set(Calendar.MONTH, 5);
		calendar.set(Calendar.DAY_OF_MONTH, 13);
		person.setDateOfBirth(calendar.getTime());

		// Creo el pasaporte
		Passport pasaporte = new Passport();
		pasaporte.setCountry("Spain");
		pasaporte.setNumber("X-1234567890");
		calendar.set(Calendar.YEAR, 2012);
		calendar.set(Calendar.MONTH, 3);
		calendar.set(Calendar.DAY_OF_MONTH, 31);
		pasaporte.setDateOfExpedition(calendar.getTime());
		calendar.set(Calendar.YEAR, 2022);
		calendar.set(Calendar.MONTH, 3);
		calendar.set(Calendar.DAY_OF_MONTH, 31);
		pasaporte.setEndOfValidity(calendar.getTime());

		//Importante, debe existir como entidad antes de añadirlo o no podré establecer las relaciones (no tiene ID aún)
		passportDao.insert(pasaporte);

		person.setPassport(pasaporte);
		personDAO.insert(person);

		session.close();

	}

}
