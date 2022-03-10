package org.iesalixar.servidor.dto;

import java.io.Serializable;

public class AsignaturaDTO implements Serializable {

	private Long asignatura;
	private Long profesor;
	
	public AsignaturaDTO() {
		// TODO Auto-generated constructor stub
	}

	public Long getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Long asignatura) {
		this.asignatura = asignatura;
	}

	public Long getProfesor() {
		return profesor;
	}

	public void setProfesor(Long profesor) {
		this.profesor = profesor;
	}

	
	
	
	
	
}
