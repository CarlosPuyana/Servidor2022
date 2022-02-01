package org.iesalixar.servidor.hibernate.manytomany.dao;

import java.util.List;

import org.hibernate.Session;
import org.iesalixar.servidor.hibernate.manytomany.model.Product;
import org.iesalixar.servidor.hibernate.manytomany.model.Subject;
import org.iesalixar.servidor.hibernate.utils.dao.GenericDAOImpl;

public class ProductDAOImpl extends GenericDAOImpl<Product> implements ProductDAO {

	private Session session;

	public ProductDAOImpl(Session session) {
		super(session);
		this.session = session;
	}

	@Override
	public Product searchByBarCode(final String barCode) {

		// Compruebo que la conexión está actica
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Recupero los productos por código de barras
		// No es una consulta Nativa uso el nombre de la clase
		List<Product> productList = session.createQuery("FROM Product WHERE barCode=:barCode")
				.setParameter("barCode", barCode)
				.list();

		// Como el barCode es único si me devuelve algo me quedo con el primero
		Product product = null;
		if (productList != null && productList.size() > 0) {
			product = productList.get(0);
		}

		return product;
	}

}
