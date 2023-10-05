package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Guest;


public interface GuestRepository extends JpaRepository <Guest, Integer>{

}
