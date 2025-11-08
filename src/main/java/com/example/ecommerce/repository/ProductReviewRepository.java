package com.example.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.entity.ProductReview;

public interface ProductReviewRepository extends JpaRepository<ProductReview, Long> {

}
