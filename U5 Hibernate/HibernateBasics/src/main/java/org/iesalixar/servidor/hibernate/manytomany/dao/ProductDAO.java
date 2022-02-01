package org.iesalixar.servidor.hibernate.manytomany.dao;

import org.iesalixar.servidor.hibernate.manytomany.model.Product;
import org.iesalixar.servidor.hibernate.utils.dao.GenericDAO;

public interface ProductDAO extends GenericDAO<Product> {

	public Product searchByBarCode(final String barCode);
}
