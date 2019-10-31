package com.supermarket.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_BASKET")
public class Basket {
	
	@Id
	@GeneratedValue
	private long idBasket;
	
	@Column
	private int nbProducts;
	
	@Column
	private double totalPrice;
	
	@OneToMany(mappedBy = "basketProduct", cascade = CascadeType.ALL)
	private List<Product> products;

	public int getNbProducts() {
		return nbProducts;
	}
	public void setNbProducts(int nbProducts) {
		this.nbProducts = nbProducts;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public void addProduct(Product product){
		if(this.products == null){
			this.products = new ArrayList<Product>();
		}
		this.products.add(product);
	}
	

}
