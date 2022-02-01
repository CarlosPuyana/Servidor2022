package org.iesalixar.servidor.hibernate.manytomany.model;

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
@Table(name="products")
public class Product {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="name",nullable=false,length=100)
	private String name;
	
	@Column(name="barCode",nullable=false,unique=true,length=100)
	private String barCode;
	
	@Column(name="price",nullable=false)
	private Double price;
	
	@OneToMany(mappedBy="product",cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<OrderDetail> orderDetails = new HashSet<>();
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Set<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	@Override
	public int hashCode() {
		return Objects.hash(barCode, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(barCode, other.barCode) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name);
	}

	

	
}
