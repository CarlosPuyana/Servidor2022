package org.iesalixar.servidor.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "payments")
public class Payments implements Serializable {

	@ManyToOne()
	@JoinColumn(name = "customerNumber")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerNumber;

	@Id
	@Column(name = "checkNumber")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String checkNumber;

	@Column(name = "date", nullable = false)
	private String date;

	@Column(name = "amount", nullable = false)
	private Double amount;

	public Payments() {
		// TODO Auto-generated constructor stub
	}

	public Payments(int customerNumber, String checkNumber, String date, Double amount) {
		super();
		this.customerNumber = customerNumber;
		this.checkNumber = checkNumber;
		this.date = date;
		this.amount = amount;
	}

	public int getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

}
