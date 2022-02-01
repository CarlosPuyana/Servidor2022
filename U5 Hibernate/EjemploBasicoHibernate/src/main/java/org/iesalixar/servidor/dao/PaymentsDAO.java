package org.iesalixar.servidor.dao;

import java.util.List;

import org.iesalixar.servidor.model.Payments;

public interface PaymentsDAO {
	public List<Payments> getAllPayments();
	public Payments getPayments(int customerNumber);
	
}
