package com.bookingapp.paymentservice.service;

import com.bookingapp.paymentservice.entity.Payment;
import com.bookingapp.paymentservice.repository.PaymentRepository;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Transactional
    public Payment processPayment(Long bookingId, Long userId, Double amount) throws Exception {
        // Create a PaymentIntent with Stripe
        PaymentIntentCreateParams params =
                PaymentIntentCreateParams.builder()
                        .setAmount((long) (amount * 100)) // Amount in cents
                        .setCurrency("usd")
                        .setDescription("Booking Payment")
                        .build();

        PaymentIntent paymentIntent = PaymentIntent.create(params);

        // Save payment information in the database
        Payment payment = new Payment();
        payment.setBookingId(bookingId);
        payment.setUserId(userId);
        payment.setAmount(amount);
        payment.setPaymentStatus(paymentIntent.getStatus());
        payment.setPaymentTime(LocalDateTime.now());

        return paymentRepository.save(payment);
    }

    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id).orElse(null);
    }
}
