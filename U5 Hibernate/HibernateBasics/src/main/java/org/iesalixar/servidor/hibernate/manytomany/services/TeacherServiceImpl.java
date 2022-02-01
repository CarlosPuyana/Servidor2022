package org.iesalixar.servidor.hibernate.manytomany.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.iesalixar.servidor.hibernate.manytomany.dao.TeacherDAO;
import org.iesalixar.servidor.hibernate.manytomany.dao.TeacherDAOImpl;
import org.iesalixar.servidor.hibernate.manytomany.dao.TeacherDAO;
import org.iesalixar.servidor.hibernate.manytomany.model.Teacher;
import org.iesalixar.servidor.hibernate.manytomany.model.Teacher;

public class TeacherServiceImpl implements TeacherService {

	// El servicio encapsulará el uso del DAO
		// y añadirá logica de negocio necesaria
		private TeacherDAO teacherDao;

		public TeacherServiceImpl(final Session session) {

			this.teacherDao = new TeacherDAOImpl(session);
		}

		@Override
		public void insertNewTeacher(final Teacher teacher) {

			// Compruebo que no es nulo y que aún no existe
			// es decir no tiene ID
			if (teacher != null && teacher.getId() == null) {
				// Inserción del publisher
				teacherDao.insert(teacher);
			}

		}

		@Override
		public void updateTeacher(final Teacher teacher) {

			// Compruebo que no es nulo y que ya existe (tiene ID)
			if (teacher != null && teacher.getId() != null) {

				// Actualizo el teacher
				teacherDao.update(teacher);
			}
		}

		@Override
		public void deleteTeacher(final Teacher teacher) {

			// Compruebo que no es nulo y que ya existe (tiene ID)
			if (teacher != null && teacher.getId() != null) {

				// Borro el teacher
				teacherDao.delete(teacher);
			}
		}

		@Override
		public Teacher searchById(final Long teacherId) {

			Teacher teacher = null;

			if (teacherId != null) {

				teacher = teacherDao.searchById(teacherId);
			}

			return teacher;
		}

		@Override
		public List<Teacher> searchAll() {
			
			List<Teacher> teacherList = new ArrayList<Teacher>();

			teacherList = teacherDao.searchAll();

			return teacherList;
		}

		@Override
		public Teacher searchTeacherByNSS(final String nss) {
			
			Teacher teacher = null;

			if (nss != null) {
				
				teacher = teacherDao.searchByNSS(nss);
			}

			return teacher;
		}

		


}
