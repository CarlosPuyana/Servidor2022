package org.iesalixar.servidor.hibernate.onetoone.dao;

import org.iesalixar.servidor.hibernate.onetoone.model.Passport;
import org.iesalixar.servidor.hibernate.utils.dao.GenericDAO;

public interface PassportDAO extends GenericDAO<Passport>{
	
	public Passport searchByNumber(final String number);
	
	// AQUÍ PODRíA TENER OTRAS OPERACIONES QUE FUERAN SOLO TÍPICAS DE ESTE MODELO 
}
