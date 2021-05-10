package com.spring.service;

import java.util.Random;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.entity.Payments;
import com.spring.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;
	
	private Logger log = LoggerFactory.getLogger(PaymentService.class);
	
	public Payments doPayment(Payments payments) throws JsonProcessingException {
		payments.setTransactionId(UUID.randomUUID().toString());
		payments.setPaymentStatus(paymentProcessing());
		log.info("Payment service request:: " + new ObjectMapper().writeValueAsString(payments));
		return paymentRepository.save(payments);
	}
	
	public String paymentProcessing() {
		return new Random().nextBoolean()?"success":"fail";
	}

	public Payments findByOrderId(int orderId) throws JsonProcessingException {
		Payments objPayment = paymentRepository.findByOrderId(orderId);
		log.info("Payment service findByOrderId() :: " + new ObjectMapper().writeValueAsString(objPayment));
		return objPayment;
	}
}
