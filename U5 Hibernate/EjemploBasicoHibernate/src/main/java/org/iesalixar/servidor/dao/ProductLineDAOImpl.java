package org.iesalixar.servidor.dao;

import java.util.List;

import org.hibernate.Session;
import org.iesalixar.servidor.bd.HibernateUtils;
import org.iesalixar.servidor.model.ProductLine;



public class ProductLineDAOImpl implements ProductLineDAO {

	private Session session;

	public ProductLineDAOImpl() {
		session = HibernateUtils.getSessionFactory().openSession();
	}

	@Override
	public List<ProductLine> getAllProductLine() {

		// Obtengo la session de Hibernate para poder trabajar
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		List<ProductLine> categorias = session.createNativeQuery("select * from productlines", ProductLine.class)
				.list();

		// Versión HQL
		// List<ProductLine> categorias = session.createQuery("FROM
		// productLines").list();

		return categorias;
	}

	@Override
	public ProductLine getProductLineByName(String nombre) {

		// Obtengo la session de Hibernate para poder trabajar
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
		
		List<ProductLine> categorias = session.createNativeQuery("select * from productlines where productline="+nombre, ProductLine.class).list();

		// Versión HQL
		// List<ProductLine> categorias = session.createQuery("FROM
		// productLines WHERE productlines="+nombre).list();

		ProductLine categoria = null;
		if(categorias != null && categorias.size() > 0) {
			categoria = categorias.get(0);
		}

		return categoria;

	}

}
