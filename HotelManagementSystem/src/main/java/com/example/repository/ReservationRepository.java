package com.example.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.entity.Reservation;

public interface ReservationRepository extends JpaRepository <Reservation, Integer> {

}
