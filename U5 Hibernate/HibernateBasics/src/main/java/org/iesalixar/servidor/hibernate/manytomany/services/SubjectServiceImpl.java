package org.iesalixar.servidor.hibernate.manytomany.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.iesalixar.servidor.hibernate.manytomany.dao.SubjectDAO;
import org.iesalixar.servidor.hibernate.manytomany.dao.SubjectDAOImpl;
import org.iesalixar.servidor.hibernate.manytomany.model.Subject;
import org.iesalixar.servidor.hibernate.onetomany.model.Publisher;

public class SubjectServiceImpl implements SubjectService {

	// El servicio encapsulará el uso del DAO
	// y añadirá logica de negocio necesaria
	private SubjectDAO subjectDao;

	public SubjectServiceImpl(final Session session) {

		this.subjectDao = new SubjectDAOImpl(session);
	}

	@Override
	public void insertNewSubject(final Subject subject) {

		// Compruebo que no es nulo y que aún no existe
		// es decir no tiene ID
		if (subject != null && subject.getId() == null) {
			// Inserción del publisher
			subjectDao.insert(subject);
		}

	}

	@Override
	public void updateSubject(final Subject subject) {

		// Compruebo que no es nulo y que ya existe (tiene ID)
		if (subject != null && subject.getId() != null) {

			// Actualizo el subject
			subjectDao.update(subject);
		}
	}

	@Override
	public void deleteSubject(final Subject subject) {

		// Compruebo que no es nulo y que ya existe (tiene ID)
		if (subject != null && subject.getId() != null) {

			// Borro el subject
			subjectDao.delete(subject);
		}
	}

	@Override
	public Subject searchById(final Long subjectId) {

		Subject subject = null;

		if (subjectId != null) {

			subject = subjectDao.searchById(subjectId);
		}

		return subject;
	}

	@Override
	public List<Subject> searchAll() {
		
		List<Subject> subjectList = new ArrayList<Subject>();

		subjectList = subjectDao.searchAll();

		return subjectList;
	}

	@Override
	public Subject searchSubjectByNname(final String name) {
		
		Subject subject = null;

		if (name != null) {
			
			subject = subjectDao.searchByName(name);
		}

		return subject;
	}

}
