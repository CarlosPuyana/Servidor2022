package org.iesalixar.servidor.services;

import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.model.Departamento;

public interface DepartamentoService {
	
	public List<Departamento> getAllDepartments();
	public Departamento getDepartamentByName(String nombre);
	public Departamento insertarDepartamento(Departamento departamento);
	public Departamento getDeparById(Long id);
	public Departamento actualizarDepart(Departamento departamento);
	

}
