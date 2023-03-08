package com.example.productorderservice.payment.adapter;

import com.example.productorderservice.payment.domain.Payment;

interface PaymentGateway {
    void execute(Payment payment);

    void execute(int price, String cardNumber);
}
