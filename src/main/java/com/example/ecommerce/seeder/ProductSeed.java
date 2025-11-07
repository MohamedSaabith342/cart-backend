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
			
            List<Product> demoProducts = List.of(
                 
                    new Product(null, "Apple iPhone 15", 799.0, "Smartphones", "Smartphone with A16 Bionic chip and OLED display", 4.8, "Apple Store", 10),
                    new Product(null, "Samsung Galaxy S24", 749.0, "Smartphones", "Flagship Android phone with 120Hz AMOLED display", 4.7, "Samsung Store", 15),
                    new Product(null, "Google Pixel 8", 699.0, "Smartphones", "AI-powered smartphone with Google Tensor G3 chip", 4.6, "Google Store", 12),
                    new Product(null, "OnePlus 12", 699.0, "Smartphones", "Fast-charging smartphone with Snapdragon 8 Gen 3 processor", 4.5, "OnePlus", 18),

                   
                    new Product(null, "Dell XPS 13", 1199.0, "Laptops", "13-inch laptop with Intel i7 and 16GB RAM", 4.9, "Dell", 5),
                    new Product(null, "HP Pavilion 15", 899.0, "Laptops", "Mid-range laptop with Ryzen 7 and 512GB SSD", 4.5, "HP Store", 8),
                    new Product(null, "Apple MacBook Air M2", 1249.0, "Laptops", "Lightweight laptop with M2 chip and 8GB RAM", 4.9, "Apple", 6),
                    new Product(null, "Asus ROG Strix G16", 1499.0, "Laptops", "Gaming laptop with RTX 4070 GPU and 165Hz display", 4.8, "Asus", 7),

                 
                    new Product(null, "Sony WH-1000XM5", 349.0, "Headphones", "Noise-cancelling wireless headphones", 4.8, "Sony Center", 20),
                    new Product(null, "Logitech MX Master 3S", 99.0, "Accessories", "Wireless ergonomic mouse with fast scrolling", 4.7, "Logitech", 25),
                    new Product(null, "Razer BlackWidow V4", 169.0, "Accessories", "Mechanical gaming keyboard with RGB lighting", 4.6, "Razer", 14),

                   
                    new Product(null, "Samsung 27'' 4K Monitor", 279.0, "Monitors", "Ultra HD monitor with HDR10 support", 4.6, "Amazon", 14),
                    new Product(null, "LG UltraGear 32''", 349.0, "Monitors", "Gaming monitor with 165Hz refresh rate", 4.7, "LG", 9),

                    
                    new Product(null, "Anker PowerCore 20000", 49.0, "Power & Chargers", "Portable power bank with fast charging", 4.8, "Anker", 30),
                    new Product(null, "Belkin 65W USB-C Charger", 59.0, "Power & Chargers", "Compact GaN charger with dual USB-C ports", 4.6, "Belkin", 40)
                );

			
			productRepository.saveAll(demoProducts);
			System.out.println("Seeded Demo Products");			
		}else {
			System.out.println("Products Already inserted");
		}
	}
	
	
	
}
