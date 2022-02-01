package org.iesalixar.servidor.dao;

import java.util.List;

import org.iesalixar.servidor.model.Customers;

public interface CustomersDAO {
	public List<Customers> getAllCustomers();
	public Customers getOrders(int customerNumber);
	
	
}
