package org.iesalixar.servidor.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "departaments")
public class Departamento implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String name;

	@ManyToOne
	private Empresa empresa;
	
	@OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Puesto> puesto = new HashSet<>();

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<Sede> sedes = new HashSet<>();

	public Departamento() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Puesto> getPuesto() {
		return puesto;
	}

	public void setPuesto(Set<Puesto> puesto) {
		this.puesto = puesto;
	}

	public Set<Sede> getSedes() {
		return sedes;
	}

	public void setSedes(Set<Sede> sedes) {
		this.sedes = sedes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Departamento [id=" + id + ", name=" + name + "]";
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	// MÉTODOS HELPERS
	public void addSede(final Sede sede) {
		this.sedes.add(sede);
		sede.getDepartamentos().add(this);
	}

	public void removeSede(final Sede sede) {
		this.sedes.remove(sede);
		sede.getDepartamentos().remove(this);
	}
	
	public void addEmpleado(Empleado empleado, String puesto) {
		Puesto job = new Puesto(this, empleado, puesto);
		this.puesto.add(job);
		empleado.getDepartamento().add(job);
		
		
	}
	
	public void removeEmpleado(final Empleado empleado) {
		this.puesto.remove(empleado);
		empleado.getDepartamento().remove(this);
	}

}
