package org.iesalixar.servidor.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Offices")
public class Offices implements Serializable{
	@Id
    @Column(name="officeCode")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String officeCode;

    @Column(name="city",nullable=false)
    private String city;

    @Column(name="phone",nullable=false)
    private String phone;

    @Column(name="addressLine1",nullable=false)
    private String addressLine1;

    @Column(name="addressLine2",nullable=false)
    private String addressLine2;

    @Column(name="state",nullable=false)
    private String state;

    @Column(name="country",nullable=false)
    private String country;

    @Column(name="postalCode",nullable=false)
    private String postalCode;

    @Column(name="territory",nullable=false)
    private String territory;

    @OneToMany( fetch=FetchType.LAZY, 
            mappedBy="officeCode")
    private List<Employees> employeesList;
    
	public Offices() {
		
	}

	public Offices(String officeCode, String city, String phone, String addressLine1, String addressLine2, String state,
			String country, String postalCode, String territory) {
		super();
		this.officeCode = officeCode;
		this.city = city;
		this.phone = phone;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
		this.territory = territory;
	}

	public String getOfficeCode() {
		return officeCode;
	}

	public void setOfficeCode(String officeCode) {
		this.officeCode = officeCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getTerritory() {
		return territory;
	}

	public void setTerritory(String territory) {
		this.territory = territory;
	}

	public List<Employees> getEmployeesList() {
		return employeesList;
	}

	public void setEmployeesList(List<Employees> employeesList) {
		this.employeesList = employeesList;
	}
		
	
	
}
