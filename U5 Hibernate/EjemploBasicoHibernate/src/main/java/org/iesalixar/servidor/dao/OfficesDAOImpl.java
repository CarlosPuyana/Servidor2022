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
		
		List<Offices> oficinas = session.createNativeQuery("select * from offices", Offices.class).list();
		
		return oficinas;
		
	}


	@Override
	public Offices getEmployeesFromCity(String ciudad) {
		
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
		
		List<Offices> empleados = session.createNativeQuery("Select * from offices where city='" + ciudad + "'", Offices.class).list();
		
		Offices oficina = null;
		if(empleados != null && empleados.size() > 0) {
			oficina = empleados.get(0);
		}
		
		return oficina;
	}

}
