package org.iesalixar.servidor.hibernate.onetomany.dao;

import org.iesalixar.servidor.hibernate.onetomany.model.Publisher;
import org.iesalixar.servidor.hibernate.utils.dao.GenericDAO;

public interface PublisherDAO extends GenericDAO<Publisher> {

	public Publisher searchByName(final String name);
}
