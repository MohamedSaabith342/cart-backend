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
			
			List<Product> demoProducts = List.of(  new Product(null, "Samsung Galaxy S24", 749.0, "Flagship Android phone with 120Hz AMOLED display", 4.7, "Samsung Store", 15),
	                new Product(null, "Google Pixel 8", 699.0, "AI-powered smartphone with Google Tensor G3 chip", 4.6, "Google Store", 12),
	                new Product(null, "Dell XPS 13", 1199.0, "13-inch laptop with Intel i7 processor and 16GB RAM", 4.9, "Dell", 5),
	                new Product(null, "HP Pavilion 15", 899.0, "Mid-range laptop with Ryzen 7 and 512GB SSD", 4.5, "HP Store", 8),
	                new Product(null, "Apple MacBook Air M2", 1249.0, "Lightweight laptop with M2 chip and 8GB RAM", 4.9, "Apple", 6),
	                new Product(null, "Sony WH-1000XM5", 349.0, "Noise-cancelling wireless headphones", 4.8, "Sony Center", 20),
	                new Product(null, "Logitech MX Master 3S", 99.0, "Wireless ergonomic mouse with fast scrolling", 4.7, "Logitech", 25),
	                new Product(null, "Samsung 27'' 4K Monitor", 279.0, "Ultra HD monitor with HDR10 support", 4.6, "Amazon", 14),
	                new Product(null, "Anker PowerCore 20000", 49.0, "Portable power bank with fast charging", 4.8, "Anker", 30),
					  new Product(null, "Samsung Galaxy S24", 749.0, "Flagship Android phone with 120Hz AMOLED display", 4.7, "Samsung Store", 15),
		                new Product(null, "Google Pixel 8", 699.0, "AI-powered smartphone with Google Tensor G3 chip", 4.6, "Google Store", 12),
		                new Product(null, "Dell XPS 13", 1199.0, "13-inch laptop with Intel i7 processor and 16GB RAM", 4.9, "Dell", 5),
		                new Product(null, "HP Pavilion 15", 899.0, "Mid-range laptop with Ryzen 7 and 512GB SSD", 4.5, "HP Store", 8),
		                new Product(null, "Apple MacBook Air M2", 1249.0, "Lightweight laptop with M2 chip and 8GB RAM", 4.9, "Apple", 6),
		                new Product(null, "Sony WH-1000XM5", 349.0, "Noise-cancelling wireless headphones", 4.8, "Sony Center", 20),
		                new Product(null, "Logitech MX Master 3S", 99.0, "Wireless ergonomic mouse with fast scrolling", 4.7, "Logitech", 25),
		                new Product(null, "Samsung 27'' 4K Monitor", 279.0, "Ultra HD monitor with HDR10 support", 4.6, "Amazon", 14),
		                new Product(null, "Anker PowerCore 20000", 49.0, "Portable power bank with fast charging", 4.8, "Anker", 30)
					);
			
			productRepository.saveAll(demoProducts);
			System.out.println("Seeded Demo Products");			
		}else {
			System.out.println("Products Already inserted");
		}
	}
	
}
