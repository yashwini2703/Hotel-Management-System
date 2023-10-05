package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.BillingAndPayment;

public interface BillingAndPaymentRepository extends JpaRepository <BillingAndPayment, Integer> {

}
