package org.iesalixar.servidor.hibernate.onetomany.services;

import java.util.List;

import org.iesalixar.servidor.hibernate.onetomany.model.Publisher;

public interface PublisherService {
	
	public void insertNewPublisher(final Publisher book);	
	 
	public void updatePublisher(final Publisher book);	
	
	public void deletePublisher(final Publisher book);
	
	public Publisher searchById(final Long publisherId);
	
	public List<Publisher> searchAll();
	
	public Publisher searchPublisherByName(final String name);

}
