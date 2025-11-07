package com.example.ecommerce.seeder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.ecommerce.entity.Product;
import com.example.ecommerce.repository.ProductRepository;

@Component
public class ProductSeed implements CommandLineRunner  {
	
	@Autowired
	private ProductRepository productRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		if (productRepository.count() == 0) {
			
			List<Product> demoProducts = List.of(new Product(null, "Apple iphone 15",799.0, "SmartPhone with a16 chip",4.8,"Amzon",5));
			
			productRepository.saveAll(demoProducts);
			System.out.println("Seeded Demo Products");			
		}else {
			System.out.println("Products Already inserted");
		}
	}
	
}
