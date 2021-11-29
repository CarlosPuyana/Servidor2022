package org.iesalixar.servidor.dao;

import java.util.ArrayList;

import org.iesalixar.servidor.model.Orders;

public interface DAOOrders {

	public Orders getOrder(int orderNumber);
	public ArrayList<Orders> getAllOrders();
	
}
