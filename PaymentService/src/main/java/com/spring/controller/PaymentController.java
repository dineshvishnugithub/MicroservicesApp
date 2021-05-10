package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.spring.entity.Payments;
import com.spring.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping("/doPayment")
	public Payments doPayment(@RequestBody Payments payments) throws JsonProcessingException {
		return paymentService.doPayment(payments);
	}
	
	@GetMapping("/{orderId}")
	public Payments findByOrderId(@PathVariable int orderId) throws JsonProcessingException {
		return paymentService.findByOrderId(orderId);
	}

}
