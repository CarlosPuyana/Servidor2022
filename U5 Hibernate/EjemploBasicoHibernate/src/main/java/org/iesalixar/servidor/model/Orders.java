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
@Table(name = "orders")
public class Orders implements Serializable {

	@Id
	@Column(name = "orderNumber")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderNumber;

	@Column(name = "orderDate", nullable = false)
	private String orderDate;

	@Column(name = "requiredDate", nullable = false)
	private String requiredDate;

	@Column(name = "shippedDate", nullable = false)
	private String shippedDate;

	@Column(name = "status", nullable = false)
	private String status;

	@Column(name = "comments", nullable = false)
	private String comments;

	@ManyToOne()
	@JoinColumn(name = "customerNumber")
	private Customers customerNumber;

//	private ArrayList<OrderDetails> orderDetails;  

	public Orders() {
		// TODO Auto-generated constructor stub
	}

	public Orders(int orderNumber, String orderDate, String requiredDate, String shippedDate, String status,
			String comments, Customers customerNumber) {
		super();
		this.orderNumber = orderNumber;
		this.orderDate = orderDate;
		this.requiredDate = requiredDate;
		this.shippedDate = shippedDate;
		this.status = status;
		this.comments = comments;
		this.customerNumber = customerNumber;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getRequiredDate() {
		return requiredDate;
	}

	public void setRequiredDate(String requiredDate) {
		this.requiredDate = requiredDate;
	}

	public String getShippedDate() {
		return shippedDate;
	}

	public void setShippedDate(String shippedDate) {
		this.shippedDate = shippedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Customers getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(Customers customerNumber) {
		this.customerNumber = customerNumber;
	}

}
