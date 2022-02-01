package org.iesalixar.servidor.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@IdClass(Puesto.class)
public class Puesto {

	@Id
	@ManyToOne
	@JoinColumn(name="departamento", insertable = false, updatable = false)
	private Departamento departamento;
	
	@Id
	@ManyToOne
	@JoinColumn(name="empleado", insertable = false, updatable = false)
	private Empleado empleados;
	
	
	
	private String puesto;
	
	public Puesto() {
		// TODO Auto-generated constructor stub
	}

	
	



	public Puesto(Departamento departamentos, Empleado empleados) {
		super();
		this.departamento = departamentos;
		this.empleados = empleados;
	}






	public Puesto(Departamento departamentos, Empleado empleados, String puesto) {
		super();
		this.departamento = departamentos;
		this.empleados = empleados;
		this.puesto = puesto;
	}






	public Empleado getEmpleados() {
		return empleados;
	}



	public void setEmpleados(Empleado empleados) {
		this.empleados = empleados;
	}



	public Departamento getDepartamentos() {
		return departamento;
	}



	public void setDepartamentos(Departamento departamentos) {
		this.departamento = departamentos;
	}



	public String getPuesto() {
		return puesto;
	}



	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}



	@Override
	public int hashCode() {
		return Objects.hash(departamento, empleados, puesto);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Puesto other = (Puesto) obj;
		return Objects.equals(departamento, other.departamento) && Objects.equals(empleados, other.empleados)
				&& Objects.equals(puesto, other.puesto);
	}
	
	
	
	
}
