package org.iesalixar.servidor.dao;

import java.util.ArrayList;

import org.iesalixar.servidor.model.Product;



public interface DAOProduct {

	public Product getProducts(String productName);

	public ArrayList<Product> getProduct(String productCode);
	
	
}
