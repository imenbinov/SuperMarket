package com.supermarket;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.supermarket.model.Product;
import com.supermarket.services.ProductService;

@SpringBootApplication
public class SuperMarketApplication extends SpringBootServletInitializer implements CommandLineRunner{

	@Autowired
	ProductService productService;
	
	public static void main(String[] args) {
		SpringApplication.run(SuperMarketApplication.class, args);
	}
    /**
     * Save All Products
     */
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Product product =  new Product();
		product.setName("Apple");
		product.setPrice(0.20);
		this.productService.saveProduct(product);
		System.out.println("succes save Apple");
		product =  new Product();
		product.setName("Orange");
		product.setPrice(0.50);
		this.productService.saveProduct(product);
		System.out.println("succes save Orange");
		product =  new Product();
		product.setName("Watermelon");
		product.setPrice(0.80);
		System.out.println("succes save Watermelon");
		this.productService.saveProduct(product);

	}

	

	
}
