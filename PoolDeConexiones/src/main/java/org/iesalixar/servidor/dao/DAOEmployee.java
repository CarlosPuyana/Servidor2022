package org.iesalixar.servidor.dao;

import java.util.ArrayList;

import org.iesalixar.servidor.model.Employee;

public interface DAOEmployee {

	public ArrayList<Employee> getAllEmployeesFromOffice(String officeCode);
	
}
