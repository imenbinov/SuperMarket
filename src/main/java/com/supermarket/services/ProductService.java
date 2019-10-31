package com.supermarket.services;

import com.supermarket.model.Product;

public interface ProductService {

	public void saveProduct(Product product);
	public Product getProductByName(String nameProduct);
	
}
