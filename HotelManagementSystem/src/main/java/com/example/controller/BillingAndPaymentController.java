package com.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.BillingAndPayment;
import com.example.exceptionhandling.EntityNotFoundException;
import com.example.service.BillingAndPaymentService;

@RestController
public class BillingAndPaymentController {
@Autowired
BillingAndPaymentService billingandpaymentService;

@PostMapping("/billingandpayments")
public BillingAndPayment addBillingAndPayment(@Valid @RequestBody BillingAndPayment billingandpayment) throws EntityNotFoundException {
	return billingandpaymentService.addBillingAndPayment(billingandpayment);
}

@GetMapping("/billingandpayments")
public List<BillingAndPayment> getAllBillingAndPayment()
{
	return billingandpaymentService.getAllBillingAndPayment();
}

@GetMapping("/billingandpayments/{id}")
public BillingAndPayment findBillingAndPaymentById(@PathVariable int id) throws EntityNotFoundException {
      return billingandpaymentService.getBillingAndPaymentById(id);
}

@DeleteMapping("/billingandpayments/{id}")
public String deleteBillingAndPayment(@PathVariable int id) throws EntityNotFoundException{
	return billingandpaymentService.deleteBillingAndPaymentById(id);
}

@PutMapping("/billingandpayments")
public BillingAndPayment updateBillingAndPaymentById(@RequestBody BillingAndPayment billingandpayment) {
	return billingandpaymentService.updateBillingAndPaymentById(billingandpayment);
}







}
