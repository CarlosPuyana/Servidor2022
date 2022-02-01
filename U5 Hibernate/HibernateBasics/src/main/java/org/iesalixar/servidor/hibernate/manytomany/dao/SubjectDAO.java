package org.iesalixar.servidor.hibernate.manytomany.dao;

import org.iesalixar.servidor.hibernate.manytomany.model.Subject;
import org.iesalixar.servidor.hibernate.utils.dao.GenericDAO;

public interface SubjectDAO extends GenericDAO<Subject> {

	public Subject searchByName(final String name);
}
