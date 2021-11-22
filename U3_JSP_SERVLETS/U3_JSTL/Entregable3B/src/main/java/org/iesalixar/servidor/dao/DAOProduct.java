package org.iesalixar.servidor.dao;

import java.util.ArrayList;
import java.util.List;

import org.iesalixar.servidor.model.Product;



public interface DAOProduct {

	public Product getProducts(String productName);

	public ArrayList<Product> getProduct(String productCode);
	
	public List<Product> getAllProducts();
	
}
