package com.example.ecommerce.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.ecommerce.dto.ProductReviewDto;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.entity.ProductReview;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.repository.ProductReviewRepository;
import com.example.ecommerce.spec.ProductSpecification;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductReviewRepository productReviewRepository;
	
	public Map<String, Object> getAllProducts(int page, int size) {
		
		Pageable pageable = PageRequest.of(page, size);
		Page<Product> products = productRepository.findAll(pageable);
		Map<String, Object> response = new HashMap();
		response.put("products", products.getContent());
		response.put("totalProducts", products.getTotalElements());
		
		
		return response;
	}
	
	
	public Product getProductById(Long id) {
		return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found with the id" + id));
	}
	
	
	public List<Product> searchProducts(String category, Double minPrice, Double maxPrice, String keyWord, Double ratings) {
		Specification<Product> spec = Specification.where(ProductSpecification.hasCategory(category))
				.and(ProductSpecification.priceBetween(minPrice, maxPrice))
				.and(ProductSpecification.hasNameOrDescription(keyWord))
				.and(ProductSpecification.ratingGreaterthan(ratings));
		
		return productRepository.findAll(spec);
	}
	
	
	public void addReview(ProductReviewDto reviewDto) {
		Product product = productRepository.findById(reviewDto.getProductId()).orElseThrow( () -> new RuntimeException("Product not found"));
		
	
		ProductReview review = new ProductReview();
		review.setComment(reviewDto.getComment());
		review.setRating(reviewDto.getRating());
		review.setProduct(product);
		
		productReviewRepository.save(review);
		
	}


	


	
	
	

}
