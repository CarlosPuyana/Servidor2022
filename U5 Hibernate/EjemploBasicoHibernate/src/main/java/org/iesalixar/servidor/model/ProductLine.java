package org.iesalixar.servidor.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "productlines")
public class ProductLine implements Serializable {

	
	@Id
	private String productLine;
	
	@Column(name="textDescription",nullable=true)	
	private String textDescription;
	
	@Column(name="htmlDescription",nullable=true)
	private String htmlDescription;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "productLine")
	private List<Product> productsList;
	
	public ProductLine() {
		// TODO Auto-generated constructor stub
	}

	public ProductLine(String productLine, String textDescription, String htmlDescription) {		
		this.productLine = productLine;
		this.textDescription = textDescription;
		this.htmlDescription = htmlDescription;
	}

	
	public String getProductLine() {
		return productLine;
	}

	
	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}

	public String getTextDescription() {
		return textDescription;
	}

	public void setTextDescription(String textDescription) {
		this.textDescription = textDescription;
	}

	public String getHtmlDescription() {
		return htmlDescription;
	}

	public void setHtmlDescription(String htmlDescription) {
		this.htmlDescription = htmlDescription;
	}

}
