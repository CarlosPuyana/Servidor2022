package org.iesalixar.servidor.hibernate.manytomany.services;

import java.util.List;

import org.iesalixar.servidor.hibernate.manytomany.model.Product;

public interface ProductService {
	
	public void insertNewProduct(final Product product);	
	 
	public void updateProduct(final Product product);	
	
	public void deleteProduct(final Product product);
	
	public Product searchById(final Long productId);
	
	public List<Product> searchAll();
	
	public Product searchProductByBarCode(final String barCode);

}
