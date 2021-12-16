package org.iesalixar.servidor.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="employees")

public class Employees implements Serializable {

	@Id
	@Column(name="employeeNumber")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long employeeNumber;
	
	@Column(name="firstName", nullable=false)
	private String firstName;
	
	@Column(name="lastName", nullable=false)
	private String lastName;
	
	@Column(name="extension", nullable=false)
	private String extension;
	
	@Column(name="email", nullable=false)
	private String email;
	
	@ManyToOne()
	@JoinColumn(name = "officeCode")
	private Offices officeCode;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "reportsTo")
	@JoinColumn(name = "reportsTo")
	@Column(name="reportsTo", nullable=true)
	private Integer reportsTo;
	
	@Column(name="jobTitle", nullable=false)
	private String jobTitle;
	
	

	public Employees() {
		super();
	}

	public Employees(int employeeNumber, String firstName, String lastName, String extension, String email,
			Offices officeCode, Integer reportsTo, String jobTitle) {
		super();
		this.employeeNumber = employeeNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.extension = extension;
		this.email = email;
		this.officeCode = officeCode;
		this.reportsTo = reportsTo;
		this.jobTitle = jobTitle;
	}

	public long getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
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

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public Offices getOfficeCode() {
		return officeCode;
	}

	public void setOfficeCode(Offices officeCode) {
		this.officeCode = officeCode;
	}

	public void setEmployeeNumber(long employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public void setReportsTo(Integer reportsTo) {
		this.reportsTo = reportsTo;
	}

	public Integer getReportsTo() {
		return reportsTo;
	}


	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

}
