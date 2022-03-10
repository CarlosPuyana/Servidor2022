package org.iesalixar.servidor.services;

import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.model.Profesor;

public interface ProfesorService {

	public Profesor findProfesorById(Long id);
	public Profesor actualizarProfesor(Profesor profesor);
	public List<Profesor> findByDepartamentoIsNull();
	public List<Profesor> getAllProfes();
	public Profesor insertarProfe(Profesor profesor);
	public Profesor getProfesorByName(String nombre);
	
	
}
