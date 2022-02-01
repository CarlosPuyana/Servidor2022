package org.iesalixar.servidor.hibernate.manytomany.dao;

import org.iesalixar.servidor.hibernate.manytomany.model.Teacher;
import org.iesalixar.servidor.hibernate.utils.dao.GenericDAO;

public interface TeacherDAO extends GenericDAO<Teacher> {

	public Teacher searchByNSS(final String nss);
}
