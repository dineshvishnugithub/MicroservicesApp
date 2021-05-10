package com.spring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.common.Payments;
import com.spring.common.TransactionRequest;
import com.spring.common.TransactionResponse;
import com.spring.entity.Order;
import com.spring.repository.OrderRepository;

@Service
@RefreshScope
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	@Lazy
	private RestTemplate objRestTemplate;
	
	@Value("${microservice.payment-service.endpoints.endpoint.uri}")
	private String PAYMENTSERVICE_ENDPOINT_URI;
	
	Logger log = LoggerFactory.getLogger(OrderService.class);
	
	public Order saveorder(Order order) throws JsonProcessingException {
		System.out.println("Inside service");
		
		System.out.println("Order service saveorder() :: " + new ObjectMapper().writeValueAsString(order));
		log.info("Order service saveorder() :: " + new ObjectMapper().writeValueAsString(order));
		
		Order result =  orderRepository.save(order);
		System.out.println("After repository called service:: " + result);
		return result;
	}
	
    public TransactionResponse createTransaction(TransactionRequest objTransactionRequest) throws JsonProcessingException {
    	String objResponseMessage = "";
		Order objOrder = objTransactionRequest.getObjOrder();
		Payments objPayments = objTransactionRequest.getObjPayments();
		objPayments.setOrderId(objOrder.getId());
		objPayments.setAmount(objOrder.getPrice());
		
		log.info("Order service request:: " + new ObjectMapper().writeValueAsString(objTransactionRequest));
		
		//call the rest service
		//if calling without apigateway
//		Payments objPaymentResponse = objRestTemplate.postForObject("http://localhost:8084/payment/doPayment", objPayments, Payments.class);
		//if calling with api gateway
//		Payments objPaymentResponse = objRestTemplate.postForObject("http://PaymentService/payment/doPayment", objPayments, Payments.class);
//		Payments objPaymentResponse = objRestTemplate.postForObject("http://PAYMENT-SERVICE/payment/doPayment", objPayments, Payments.class);
		//if calling the url registered in centralised config server
		Payments objPaymentResponse = objRestTemplate.postForObject(PAYMENTSERVICE_ENDPOINT_URI, objPayments, Payments.class);
		objResponseMessage = objPaymentResponse.getPaymentStatus().equalsIgnoreCase("success")?"Payment successfull, Order placed":"Payment failed, Order saved";
		
		log.info("Payment service response from order service rest call :: " + new ObjectMapper().writeValueAsString(objResponseMessage));
		
		Order objOrderResponse = orderRepository.save(objOrder);
		
		TransactionResponse objTransactionResponse = new TransactionResponse();
		objTransactionResponse.setObjOrder(objOrderResponse);
		objTransactionResponse.setTransactionAmount(objPaymentResponse.getAmount());
		objTransactionResponse.setMessage(objResponseMessage);
		objTransactionResponse.setTransactionId(objPaymentResponse.getTransactionId());
		
		return objTransactionResponse;
    }

}
