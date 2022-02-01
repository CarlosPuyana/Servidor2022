package org.iesalixar.servidor.dao;

import java.util.List;

import org.hibernate.Session;
import org.iesalixar.servidor.bd.HibernateUtils;
import org.iesalixar.servidor.model.Employees;
import org.iesalixar.servidor.model.Offices;

public class OfficesDAOImpl implements OfficesDAO {

private Session session;
	
	public OfficesDAOImpl() {
		session = HibernateUtils.getSessionFactory().openSession();
	}
	
	@Override
	public List<Offices> getAllOffices() {
		
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
		
		List<Offices> offices = session.createNativeQuery("select * from offices",
				Offices.class).list();
		
		return offices;
	}

	@Override
	public Offices getEmployeesByCity(String city) {
		
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
		
		List<Offices> employees = session.createNativeQuery("select * from offices where city='" +city + "'",Offices.class).list();
		
		Offices employee = null;
		if (employees!=null && employees.size()>0) {
			employee = employees.get(0);
		}
		
		return employee;
		
	}

}
