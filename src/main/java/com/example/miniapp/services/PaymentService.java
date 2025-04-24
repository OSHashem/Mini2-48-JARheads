package com.example.miniapp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.miniapp.models.Payment;
import com.example.miniapp.repositories.PaymentRepository;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    //add payment
    public Payment addPayment(Payment payment) {
        return paymentRepository.save(payment);
    }
    
    //get all payments
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    //get payment by id
    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id).orElse(null);
    }

    //update payment
    public Payment updatePayment(Long paymentID, Payment payment) {

        if (paymentRepository.existsById(paymentID)) {
            return paymentRepository.save(payment);
        } else {
            throw new IllegalArgumentException("Payment not found for ID: " + paymentID);
        }
    }

    //delete payment
    public String deletePayment(Long id) {
        if (!paymentRepository.existsById(id)) {
            return "Payment not found for ID: " + id;
        }
        paymentRepository.deleteById(id);
        return "Payment deleted successfully with ID: " + id;
    }

    // finding payment by trip id
    public List<Payment> findByTripId(Long tripId) {
        return paymentRepository.findByTripId(tripId);
    }
    // finding payments with amount greater than a certain value
    public List<Payment> findByAmountGreaterThan(Double amount) {
        return paymentRepository.findByAmountGreaterThan(amount);
    }
}
