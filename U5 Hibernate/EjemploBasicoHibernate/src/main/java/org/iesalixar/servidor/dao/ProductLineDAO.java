package org.iesalixar.servidor.dao;

import java.util.List;

import org.iesalixar.servidor.model.ProductLine;

public interface ProductLineDAO {
	
	public List<ProductLine> getAllProductLine();
	public ProductLine getProductLineByName(String name);

}
