package org.iesalixar.servidor.repositories;

import java.util.List;

import org.iesalixar.servidor.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor,Long> {

	public List<Profesor> findByDepartamentoIsNull();

	public Profesor findByNombre(String nombre);
	
}
