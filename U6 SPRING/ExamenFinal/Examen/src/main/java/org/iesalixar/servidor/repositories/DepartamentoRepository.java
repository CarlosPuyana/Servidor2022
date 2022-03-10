package org.iesalixar.servidor.repositories;

import org.iesalixar.servidor.model.Departamento;
import org.iesalixar.servidor.model.Grado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

	public Departamento findByNombre(String nombre);
}
