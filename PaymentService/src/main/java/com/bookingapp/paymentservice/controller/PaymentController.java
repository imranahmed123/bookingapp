package com.bookingapp.paymentservice.controller;

import com.bookingapp.paymentservice.entity.Payment;
import com.bookingapp.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Payment> processPayment(@RequestParam Long bookingId,
                                                  @RequestParam Long userId,
                                                  @RequestParam Double amount) {
        try {
            Payment payment = paymentService.processPayment(bookingId, userId, amount);
            return ResponseEntity.ok(payment);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
        Payment payment = paymentService.getPaymentById(id);
        return ResponseEntity.ok(payment);
    }
}
