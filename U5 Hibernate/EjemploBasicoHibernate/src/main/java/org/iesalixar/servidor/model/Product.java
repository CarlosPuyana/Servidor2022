package org.iesalixar.servidor.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;

@Entity
@Table(name = "products")
public class Product implements Serializable {

	@Id
	private String productCode;
	
	@Column(name="productName", nullable=false)	
	private String productName;
	
	@ManyToOne()
	@JoinColumn(name = "productLine")
	private ProductLine productLine;
	
	@Column(name="productScale", nullable=false)
	private String productScale;
	
	@Column(name="productVendor", nullable=false)
	private String productVendor;
	
	@Column(name="productDescription", nullable=false)
	private String productDescription;
	
	@Column(name="quantityInstock", nullable=false)
	@Min(value = 0, message = "Sin stock")
	private Integer quantityInStock;
	
	@Column(name="buyPrice", nullable=false)
	@Digits(integer = 8, fraction = 2)
	@Min(value = 0, message = "Precio de compra inferior al mínimo")	
	private Double buyPrice;
	
	@Column(name="MSRP", nullable=false)
	@Digits(integer = 8, fraction = 2)
	@Min(value = 1, message = "Precio de venta inferior al mínimo")
	private Double MSRP;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String productCode, String productName, ProductLine productLine, String productScale,
			String productVendor, String productDescription, Integer quantityInStock, Double buyPrice, Double mSRP) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productLine = productLine;
		this.productScale = productScale;
		this.productVendor = productVendor;
		this.productDescription = productDescription;
		this.quantityInStock = quantityInStock;
		this.buyPrice = buyPrice;
		MSRP = mSRP;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public ProductLine getProductLine() {
		return productLine;
	}

	public void setProductLine(ProductLine productLine) {
		this.productLine = productLine;
	}

	public String getProductScale() {
		return productScale;
	}

	public void setProductScale(String productScale) {
		this.productScale = productScale;
	}

	public String getProductVendor() {
		return productVendor;
	}

	public void setProductVendor(String productVendor) {
		this.productVendor = productVendor;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Integer getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(Integer quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	public Double getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(Double buyPrice) {
		this.buyPrice = buyPrice;
	}

	public Double getMSRP() {
		return MSRP;
	}

	public void setMSRP(Double mSRP) {
		MSRP = mSRP;
	}

	
	
	
	

}
