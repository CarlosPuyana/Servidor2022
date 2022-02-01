package org.iesalixar.servidor.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.iesalixar.servidor.dao.DepartamentoDAO;
import org.iesalixar.servidor.dao.DepartamentoDAO;
import org.iesalixar.servidor.dao.DepartamentoDAOImpl;
import org.iesalixar.servidor.model.Departamento;
import org.iesalixar.servidor.model.Departamento;

public class DepartamentoServiceImpl implements DepartamentoService {

	private DepartamentoDAO departamentoDao;

	public DepartamentoServiceImpl(final Session session) {
		this.departamentoDao = new DepartamentoDAOImpl(session);
	}

	@Override
	public void insertNewDepartamento(Departamento departamento) {

		// Compruebo que no es nulo y que aún no existe
		// es decir no tiene ID
		if (departamento != null && departamento.getId() == null) {
			// Inserción del pedido
			departamentoDao.insert(departamento);
		}

	}

	@Override
	public void updateDepartamento(Departamento departamento) {
		// Compruebo que no es nulo y que ya existe (tiene ID)
		if (departamento != null && departamento.getId() != null) {

			// Actualizo el pedido
			departamentoDao.update(departamento);
		}

	}

	@Override
	public void deleteDepartamento(Departamento departamento) {
		// Compruebo que no es nulo y que ya existe (tiene ID)
		if (departamento != null && departamento.getId() != null) {

			// Actualizo el pedido
			departamentoDao.delete(departamento);
		}
	}

	@Override
	public Departamento searchById(Long departamentoId) {
		Departamento departamento = null;

		if (departamentoId != null) {

			departamento = departamentoDao.searchById(departamentoId);
		}

		return departamento;
	}

	@Override
	public List<Departamento> searchAll() {
		
		List<Departamento> departamentoList = new ArrayList<Departamento>();

		departamentoList = departamentoDao.searchAll();

		return departamentoList;
	}

	@Override
	public List<Departamento> searchByName(String name) {
		
		List<Departamento> departamentoList = new ArrayList<Departamento>();

		if (name!=null) {
			departamentoList = departamentoDao.searchByName(name);
		}
		

		return departamentoList;
	}

}
