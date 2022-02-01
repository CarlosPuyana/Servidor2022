package org.iesalixar.servidor.dao;

import java.util.List;

import org.hibernate.Session;
import org.iesalixar.servidor.model.Empresa;
import org.iesalixar.servidor.utils.dao.GenericDAOImpl;

public class EmpresaDAOImpl extends GenericDAOImpl<Empresa> implements EmpresaDAO {

	private Session session;

	public EmpresaDAOImpl(Session session) {
		super(session);
		this.session = session;
	}

	@Override
	public Empresa searchByName(String name) {
		
		// Compruebo que la conexión está actica
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Recupero las empresas por nombre
		// No es una consulta Nativa uso el nombre de la clase
		List<Empresa> empresaList = session.createQuery("FROM Empresa WHERE name=:name")
				.setParameter("barCode", name).list();

		// El nombre de la empresa va a ser único
		Empresa empresa = null;
		if (empresaList != null && empresaList.size() > 0) {
			empresa = empresaList.get(0);
		}

		return empresa;
	}

}
