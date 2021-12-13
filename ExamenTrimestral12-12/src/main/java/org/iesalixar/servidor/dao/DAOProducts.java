package org.iesalixar.servidor.dao;

import java.util.ArrayList;

import org.iesalixar.servidor.model.Products;

public interface DAOProducts {

	public ArrayList<Products> getAllProducts();
	public ArrayList<Products> getProduct(String categoria);
	
}
