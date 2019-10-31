package com.supermarket.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supermarket.model.Product;
@Repository
public interface ProductDao extends JpaRepository<Product, Long>{

	Product findByName(String name);
	
	

}
