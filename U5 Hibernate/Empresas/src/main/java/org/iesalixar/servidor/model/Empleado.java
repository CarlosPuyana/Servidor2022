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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="empleados")
public class Empleado implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;	
	
	@OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Puesto> departamento = new HashSet<>();
	

	public Empleado() {
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	


	public Set<Puesto> getDepartamento() {
		return departamento;
	}


	public void setDepartamento(Set<Puesto> departamento) {
		this.departamento = departamento;
	}


	@Override
	public int hashCode() {
		return Objects.hash(firstName, id, lastName);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return Objects.equals(firstName, other.firstName) && Objects.equals(id, other.id)
				&& Objects.equals(lastName, other.lastName);
	}


	@Override
	public String toString() {
		return "Empleado [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	
	
}
