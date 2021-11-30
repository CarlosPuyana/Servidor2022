package org.iesalixar.servidor.dao;

import java.util.List;

import org.iesalixar.servidor.model.Offices;

public interface DAOOffice {
//	public Offices getOficina(String city);
	public List<Offices> getAllOffices();
	public Offices getOffice(String officeCode);
}
