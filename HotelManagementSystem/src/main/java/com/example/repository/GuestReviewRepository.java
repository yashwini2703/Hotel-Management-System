package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.GuestReview;

public interface GuestReviewRepository extends JpaRepository <GuestReview, Integer> {

}
