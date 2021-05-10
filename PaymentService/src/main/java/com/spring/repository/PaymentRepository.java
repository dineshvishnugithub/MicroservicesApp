package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.Payments;

@Repository
public interface PaymentRepository extends JpaRepository<Payments, Integer>{

	Payments findByOrderId(int orderId);

}
