package com.example.productorderservice.payment;

import org.springframework.util.Assert;

class PaymentRequest {
    private final Long orderId;
    private final String cardNumber;

    public PaymentRequest(Long orderId, String cardNumber) {
        Assert.notNull(orderId, "주문 아이디는 필수");
        Assert.hasText(cardNumber, "카드번호는 필수");
        this.orderId = orderId;
        this.cardNumber = cardNumber;
    }

    public Long getOrderId() {
        return orderId;
    }

    public String getCardNumber() {
        return cardNumber;
    }
}
