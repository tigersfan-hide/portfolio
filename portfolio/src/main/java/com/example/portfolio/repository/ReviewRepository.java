package com.example.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.portfolio.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
