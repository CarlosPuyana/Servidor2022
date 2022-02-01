package org.iesalixar.servidor.dao;

import java.util.List;

import org.hibernate.Session;
import org.iesalixar.servidor.bd.HibernateUtils;
import org.iesalixar.servidor.model.Customers;

public class CustomersDAOImpl implements CustomersDAO {

private Session session;
	
	public CustomersDAOImpl() {
		session = HibernateUtils.getSessionFactory().openSession();
	}
	
	@Override
	public List<Customers> getAllCustomers() {
		
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
		
		List<Customers> customers = session.createNativeQuery("select * from customers",
				Customers.class).list();
		
		return customers;
	}

	@Override
	public Customers getOrders(int customerNumber) {
		
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
		
		List<Customers> orders = session.createNativeQuery("select * from customers where customerNumber=" +customerNumber, Customers.class).list();
		
		Customers order = null;
		if (orders!=null && orders.size()>0) {
			order = orders.get(0);
		}
		
		return order;
	}

}
