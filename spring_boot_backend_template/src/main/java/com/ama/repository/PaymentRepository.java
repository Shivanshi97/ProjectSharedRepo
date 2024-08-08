package com.ama.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ama.entities.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
