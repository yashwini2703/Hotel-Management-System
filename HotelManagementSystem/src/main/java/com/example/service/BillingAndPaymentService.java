package com.example.service;

import java.util.List;

import com.example.entity.BillingAndPayment;
import com.example.exceptionhandling.EntityNotFoundException;


public interface BillingAndPaymentService {
	public BillingAndPayment addBillingAndPayment(BillingAndPayment bp) throws EntityNotFoundException;
	public List<BillingAndPayment> getAllBillingAndPayment();
    public  BillingAndPayment getBillingAndPaymentById(int id) throws EntityNotFoundException;
    public BillingAndPayment updateBillingAndPaymentById(BillingAndPayment bp);
	public String deleteBillingAndPaymentById(int id) throws EntityNotFoundException;
}
