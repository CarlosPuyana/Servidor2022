package org.iesalixar.servidor.hibernate.manytomany.services;

import java.util.List;

import org.iesalixar.servidor.hibernate.manytomany.model.Teacher;

public interface TeacherService {
	
	public void insertNewTeacher(final Teacher teacher);	
	 
	public void updateTeacher(final Teacher teacher);	
	
	public void deleteTeacher(final Teacher teacher);
	
	public Teacher searchById(final Long teacherId);
	
	public List<Teacher> searchAll();
	
	public Teacher searchTeacherByNSS(final String nss);
}
