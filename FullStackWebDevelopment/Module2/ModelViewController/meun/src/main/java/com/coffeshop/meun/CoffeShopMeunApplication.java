package com.coffeshop.meun;

import com.coffeshop.meun.model.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoffeShopMeunApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoffeShopMeunApplication.class, args);
//		Product espresso = new Product(1, "Espresso", 2.99);
//		Product croissaant = new Product(2,"Croissant", 3.49);
//
//		System.out.println("Product ID: " + espresso.getId() + "\tName: " + espresso.getName() + "\tPrice: " + espresso.getPrice());
//		System.out.println("Product ID: " + croissaant.getId() + "\tName: " + croissaant.getName() + "\tPrice: " + croissaant.getPrice());
	}



}
