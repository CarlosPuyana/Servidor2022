package org.iesalixar.servidor.dao;

import java.util.List;

import org.iesalixar.servidor.model.Empleado;
import org.iesalixar.servidor.utils.dao.GenericDAO;

public interface EmpleadoDAO extends GenericDAO<Empleado>{

	public List<Empleado> searchByFullName(final String firstName,final String lastName);
}
