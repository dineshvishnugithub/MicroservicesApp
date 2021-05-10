package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.spring.common.TransactionRequest;
import com.spring.common.TransactionResponse;
import com.spring.entity.Order;
import com.spring.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	/** test the order service 
	 * @throws JsonProcessingException **/
	@PostMapping(value="/bookOrder")
	public Order bookOrder(@RequestBody Order order) throws JsonProcessingException {
		System.out.println("order:: " + order.getId());
		return orderService.saveorder(order);
	}
	
	/** this service consumes transaction request and acts as microservices in calling the payment service from order service **/
	/** this is the original webservice 
	 * @throws JsonProcessingException **/
	@PostMapping(value="/createTransaction")
	public TransactionResponse createTransactionResponse(@RequestBody TransactionRequest objTransactionRequest) throws JsonProcessingException {
		return orderService.createTransaction(objTransactionRequest);
	}

}
