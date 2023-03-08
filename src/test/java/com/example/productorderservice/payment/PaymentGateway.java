package com.example.productorderservice.payment;

interface PaymentGateway {
    void execute(Payment payment);

    void execute(int price, String cardNumber);
}
