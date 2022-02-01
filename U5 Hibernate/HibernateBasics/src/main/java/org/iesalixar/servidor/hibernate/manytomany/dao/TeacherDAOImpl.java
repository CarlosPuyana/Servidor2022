package org.iesalixar.servidor.hibernate.manytomany.dao;

import java.util.List;

import org.hibernate.Session;
import org.iesalixar.servidor.hibernate.manytomany.model.Teacher;
import org.iesalixar.servidor.hibernate.onetomany.model.Book;
import org.iesalixar.servidor.hibernate.utils.dao.GenericDAOImpl;

public class TeacherDAOImpl extends GenericDAOImpl<Teacher> implements TeacherDAO {

	private Session session;

	public TeacherDAOImpl(Session session) {
		super(session);
		this.session = session;
	}

	@Override
	public Teacher searchByNSS(final String nss) {

		// Compruebo que la conexión está actica
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Recupero los profesores
		// No es una consulta Nativa uso el nombre de la clase
		List<Teacher> teacherList = session.createQuery("FROM Teacher WHERE nss=:nss").setParameter("nss", nss).list();

		// Como el NSS es único si me devuelve algo me quedo con el primero
		Teacher teacher = null;
		if (teacherList != null && teacherList.size() > 0) {
			teacher = teacherList.get(0);
		}

		return teacher;

	}

}
