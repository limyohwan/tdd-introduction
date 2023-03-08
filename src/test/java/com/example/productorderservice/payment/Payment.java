package com.example.productorderservice.payment;

import com.example.productorderservice.order.Order;
import org.springframework.util.Assert;

class Payment {
    private Long id;
    private final Order order;
    private final String cardNumber;

    public Payment(Order order, String cardNumber) {
        Assert.notNull(order, "주문은 필수");
        Assert.hasText(cardNumber, "카드번호는 필수");
        this.order = order;
        this.cardNumber = cardNumber;
    }

    public Long getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void assignId(Long id) {
        this.id = id;
    }

    public int getPrice() {
        return order.getTotalPrice();
    }


}
