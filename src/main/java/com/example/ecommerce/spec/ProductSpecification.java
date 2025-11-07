package com.example.ecommerce.spec;

import org.springframework.data.jpa.domain.Specification;

import com.example.ecommerce.entity.Product;

public class ProductSpecification {
	
	public static Specification<Product> hasCategory(String category) {
		return (root, query, cb) ->  category == null ? null: cb.equal(root.get("category"),category);
	}

	
}
