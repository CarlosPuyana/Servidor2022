package org.iesalixar.servidor.dao;

import java.util.ArrayList;

import org.iesalixar.servidor.model.OrdersDetails;

public interface DAOOrdersDetails {

	public ArrayList<OrdersDetails> getDetailsFromOrder(int orderNumber);
	
}
