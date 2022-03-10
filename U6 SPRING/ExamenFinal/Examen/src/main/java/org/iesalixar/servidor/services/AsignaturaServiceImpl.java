package org.iesalixar.servidor.services;

import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.model.Asignatura;
import org.iesalixar.servidor.repositories.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsignaturaServiceImpl implements AsignaturaService {

	@Autowired
	AsignaturaRepository asigRepo;

	@Override
	public List<Asignatura> getAllAsignaturas() {
		// TODO Auto-generated method stub
		return asigRepo.findAll();
	}

	@Override
	public Optional<Asignatura> findAsigById(Long id) {

		Optional<Asignatura> asignatura = null;

		if (id != null) {
			asignatura = asigRepo.findById(id);
		}

		return asignatura;
	}

	@Override
	public Asignatura actualizarAsignatura(Asignatura asignatura) {
		
		if (asignatura==null || asignatura.getId()==null || asignatura.getNombre()==null) {
			return null;			
		}
		return asigRepo.save(asignatura);
		
	}
	
	

}
