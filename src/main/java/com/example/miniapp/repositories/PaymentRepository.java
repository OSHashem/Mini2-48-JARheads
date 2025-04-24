package com.example.miniapp.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.miniapp.models.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    //finding payment by trip id
    List<Payment> findByTripId(Long tripId); // Assuming tripId is a Long, adjust as necessary

    //finding payments with amout greater than a certain value
    List<Payment> findByAmountGreaterThan(Double amount); // Assuming amount is a Double, adjust as necessary
}
