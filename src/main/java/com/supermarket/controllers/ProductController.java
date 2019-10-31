package com.supermarket.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.supermarket.model.Basket;
import com.supermarket.model.Product;
import com.supermarket.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	
	@Autowired
	ProductService productService;
	
	@PostMapping
	public @ResponseBody Basket displayBasket(@RequestBody Basket basket){
		//Basket basket = this.fillBasketItems();
		return this.shopping(basket);
	}

	
	/**
	 * shopping calculer le montant total de panier en appliquant les remises sur des produits spécifiés
	 * @param basket
	 * @return
	 */
	private Basket shopping(Basket basket) {
		// TODO Auto-generated method stub
		Product product;
		double priceApples = 0;
		double priceWatermelons = 0;
		double totalPrice = 0;
		basket.setTotalPrice(0);
		for (Product productBasket : basket.getProducts()) {

			product = this.productService.getProductByName(productBasket.getName());
			productBasket.setIdProduct(product.getIdProduct());
			productBasket.setPrice(product.getPrice());
			if (productBasket != null && productBasket.getName().equals("Apple")) {
				/**
				 * Buy One Get One Free on Apples
				 */
				priceApples = productBasket.getQuantity() / 2 * productBasket.getPrice()
						+ (productBasket.getQuantity() % 2) * productBasket.getPrice();
			} else if (productBasket != null && productBasket.getName().equals("Watermelon")) {
				/**
				 * Three For The Price Of Two on Watermelons
				 */
				priceWatermelons = (productBasket.getQuantity() * productBasket.getPrice())
						- ((int) (productBasket.getQuantity() / 3) * productBasket.getPrice());
			} else {
				totalPrice += productBasket.getQuantity() * productBasket.getPrice();
			}

		}
		totalPrice = totalPrice + priceApples + priceWatermelons;
		basket.setTotalPrice(totalPrice);
		System.out.println("Price of Apples = " + priceApples);
		System.out.println("Price of Watermelons = " + priceWatermelons);
		System.out.println("Price of Basket = " + basket.getTotalPrice());

		return basket;
	}
	/**
	 * fillBasketItems : remplir le panier par des produits
	 * @return
	 */
//	private Basket fillBasketItems() {
//		
//		Basket basket = new Basket();
//		Product product = new Product();
//		product.setName("Apple");
//		product.setQuantity(4);
//		basket.addProduct(product);
//		basket.setNbProducts(basket.getNbProducts()+1);
//		product = new Product();
//		product.setName("Orange");
//		product.setQuantity(3);
//		basket.addProduct(product);
//		basket.setNbProducts(basket.getNbProducts()+1);
//		product = new Product();
//		product.setName("Watermelon");
//		product.setQuantity(5);
//		basket.addProduct(product);
//		basket.setNbProducts(basket.getNbProducts()+1);
//		return basket;
//		
//	}

}
