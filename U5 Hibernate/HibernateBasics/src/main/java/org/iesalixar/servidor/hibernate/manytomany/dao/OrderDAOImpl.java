package org.iesalixar.servidor.hibernate.manytomany.dao;

import java.util.List;

import org.hibernate.Session;
import org.iesalixar.servidor.hibernate.manytomany.model.Order;
import org.iesalixar.servidor.hibernate.utils.dao.GenericDAOImpl;

public class OrderDAOImpl extends GenericDAOImpl<Order> implements OrderDAO {

	private Session session;
	
	public OrderDAOImpl(Session session) {
		super(session);
		this.session = session;
	}
	
}
