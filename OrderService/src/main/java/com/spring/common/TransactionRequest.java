package com.spring.common;

import com.spring.entity.Order;

public class TransactionRequest {
	private Order objOrder;
	private Payments objPayments;
	
	public Order getObjOrder() {
		return objOrder;
	}
	public void setObjOrder(Order objOrder) {
		this.objOrder = objOrder;
	}
	public Payments getObjPayments() {
		return objPayments;
	}
	public void setObjPayments(Payments objPayments) {
		this.objPayments = objPayments;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
