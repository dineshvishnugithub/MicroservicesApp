package com.spring.common;

import com.spring.entity.Order;

public class TransactionResponse {
	private Order objOrder;
	private double transactionAmount;
	private String transactionId;
	private String message;
	
	public Order getObjOrder() {
		return objOrder;
	}
	public void setObjOrder(Order objOrder) {
		this.objOrder = objOrder;
	}
	public double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
