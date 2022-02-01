package org.iesalixar.servidor.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.iesalixar.servidor.dao.SedeDAO;
import org.iesalixar.servidor.dao.SedeDAOImpl;
import org.iesalixar.servidor.model.Sede;

public class SedeServiceImpl implements SedeService {

	private SedeDAO sedeDao;

	public SedeServiceImpl(final Session session) {
		this.sedeDao = new SedeDAOImpl(session);
	}

	@Override
	public void insertNewSede(Sede sede) {

		// Compruebo que no es nulo y que aún no existe
		// es decir no tiene ID
		if (sede != null && sede.getId() == null) {
			// Inserción del pedido
			sedeDao.insert(sede);
		}

	}

	@Override
	public void updateSede(Sede sede) {
		// Compruebo que no es nulo y que ya existe (tiene ID)
		if (sede != null && sede.getId() != null) {

			// Actualizo el pedido
			sedeDao.update(sede);
		}

	}

	@Override
	public void deleteSede(Sede sede) {
		// Compruebo que no es nulo y que ya existe (tiene ID)
		if (sede != null && sede.getId() != null) {

			// Actualizo el pedido
			sedeDao.delete(sede);
		}
	}

	@Override
	public Sede searchById(Long sedeId) {
		Sede sede = null;

		if (sedeId != null) {

			sede = sedeDao.searchById(sedeId);
		}

		return sede;
	}

	@Override
	public List<Sede> searchAll() {
		List<Sede> sedeList = new ArrayList<Sede>();

		sedeList = sedeDao.searchAll();

		return sedeList;
	}

}
