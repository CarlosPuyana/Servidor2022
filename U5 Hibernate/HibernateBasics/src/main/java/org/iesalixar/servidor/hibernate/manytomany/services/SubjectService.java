package org.iesalixar.servidor.hibernate.manytomany.services;

import java.util.List;

import org.iesalixar.servidor.hibernate.manytomany.model.Subject;

public interface SubjectService {

	public void insertNewSubject(final Subject subject);	
	 
	public void updateSubject(final Subject subject);	
	
	public void deleteSubject(final Subject subject);
	
	public Subject searchById(final Long subjectId);
	
	public List<Subject> searchAll();
	
	public Subject searchSubjectByNname(final String name);
}
