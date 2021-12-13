package org.iesalixar.servidor.dao;

import java.util.ArrayList;

import org.iesalixar.servidor.model.Employees;

public interface DAOEmployees {
	public ArrayList<Employees> getAllEmployees();
	public boolean insertEmployee(Employees employee);
	public ArrayList<Employees> getAllJefes();
	public Employees getEmpleado(String nombre);
	
}
