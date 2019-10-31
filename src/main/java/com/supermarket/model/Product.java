package com.supermarket.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TBL_PRODUCTS")
public class Product {
	@Id
	@GeneratedValue
	private Long idProduct;
	
	@Column(name="name_product")
	private String name;
	
	@Column(name="price_product")
	private double price;
	
	@Column(name="quantity_product")
	private double quantity;

	@ManyToOne
	@JoinColumn
	private Basket basketProduct;
	
	
	
	public Long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	
	
	

}
