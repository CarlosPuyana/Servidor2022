package org.iesalixar.servidor.dao;

import java.util.List;

import org.hibernate.Session;
import org.iesalixar.servidor.bd.HibernateUtils;
import org.iesalixar.servidor.model.Payments;

public class PaymentsDAOImpl implements PaymentsDAO {

	private Session session;

	public PaymentsDAOImpl() {
		session = HibernateUtils.getSessionFactory().openSession();
	}
	
	@Override
	public List<Payments> getAllPayments() {
		
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
		
		List<Payments> pagos = session.createNativeQuery("select * from payments", Payments.class)
				.list();
		
		return pagos;
	}

	@Override
	public Payments getPayments(int customerNumber) {
		
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
		
		List<Payments> pagos = session.createNativeQuery("select * from payments where customerNumber=" +customerNumber, Payments.class)
				.list();
		
		Payments pago = null;
		if(pagos != null && pagos.size() > 0) {
			pago = pagos.get(0);
		}
		
		return pago;
	}	

}
