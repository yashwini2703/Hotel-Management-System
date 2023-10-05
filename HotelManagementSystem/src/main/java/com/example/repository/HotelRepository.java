package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Hotel;

public interface HotelRepository extends JpaRepository <Hotel, Integer> {

}
