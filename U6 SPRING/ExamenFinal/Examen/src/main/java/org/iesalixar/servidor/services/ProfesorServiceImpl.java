package org.iesalixar.servidor.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.model.Profesor;
import org.iesalixar.servidor.repositories.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfesorServiceImpl implements ProfesorService {

	@Autowired
	ProfesorRepository profRepo;

	@Override
	public Profesor findProfesorById(Long id) {
		// TODO Auto-generated method stub
		return profRepo.findById(id).get();
	}

	@Override
	public Profesor actualizarProfesor(Profesor profesor) {
		// TODO Auto-generated method stub

		if (profesor == null || profesor.getId() == null) {

			return null;
		}

		return profRepo.save(profesor);
	}

	@Override
	public List<Profesor> findByDepartamentoIsNull() {

		List<Profesor> profesores = profRepo.findByDepartamentoIsNull();

		if (profesores != null && profesores.size() > 0) {

			return profesores;
		}

		return new ArrayList<Profesor>();

	}

	@Override
	public List<Profesor> getAllProfes() {
		// TODO Auto-generated method stub
		return profRepo.findAll();
	}

	@Override
	public Profesor insertarProfe(Profesor profesor) {

		if (profesor != null && getProfesorByName(profesor.getNombre()) == null) {
			Profesor profe = profRepo.save(profesor);
			
			return profe;
		}

			return null;
	}

	@Override
	public Profesor getProfesorByName(String nombre) {

		if (nombre != null) {

			Profesor profesor = profRepo.findByNombre(nombre);

			return profesor;
		}

		return null;
	}

}
