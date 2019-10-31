package com.supermarket.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supermarket.daos.ProductDao;
import com.supermarket.model.Product;
import com.supermarket.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDao productDao;
	
	@Override
	public void saveProduct(Product product) {
		// TODO Auto-generated method stub
		try {
			this.productDao.save(product);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public Product getProductByName(String nameProduct) {
		// TODO Auto-generated method stub
		Product product = null;
		try {
			 product =  this.productDao.findByName(nameProduct);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return product;
	}

}
