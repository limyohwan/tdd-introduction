package com.example.productorderservice.payment;

import com.example.productorderservice.payment.PaymentRequest;

public class PaymentSteps {
    public static PaymentRequest 주문결제요청_생성() {
        Long orderId = 1L;
        String cardNumber = "1234-1234-1234-1234";
        return new PaymentRequest(orderId, cardNumber);
    }
}
