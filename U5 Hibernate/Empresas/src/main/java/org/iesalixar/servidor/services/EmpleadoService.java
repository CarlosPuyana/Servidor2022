package org.iesalixar.servidor.services;

import java.util.List;

import org.iesalixar.servidor.model.Empleado;

public interface EmpleadoService {
	
	public void insertNewEmpleado(final Empleado empleado);	
	 
	public void updateEmpleado(final Empleado empleado);	
	
	public void deleteEmpleado(final Empleado empleado);
	
	public Empleado searchById(final Long empleadoId);
	
	public List<Empleado> searchAll();
	
	public List<Empleado> searchByFullName(final String firstName,final String lastName);

}
