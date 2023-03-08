package com.example.productorderservice.payment.application.port;

import com.example.productorderservice.order.domain.Order;
import com.example.productorderservice.payment.domain.Payment;

public interface PaymentPort {
    Order getOrder(Long orderId);

    void pay(Payment payment);

    void save(Payment payment);

    void pay(int price, String cardNumber);
}
