package com.ama.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ama.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
