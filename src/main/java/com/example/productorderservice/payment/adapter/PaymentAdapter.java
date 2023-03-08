package com.example.productorderservice.payment.adapter;

import com.example.productorderservice.order.domain.Order;
import com.example.productorderservice.order.adapter.OrderRepository;
import com.example.productorderservice.payment.application.port.PaymentPort;
import com.example.productorderservice.payment.domain.Payment;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
class PaymentAdapter implements PaymentPort {
    private final PaymentGateway paymentGateway;
    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;

    PaymentAdapter(PaymentGateway paymentGateway, PaymentRepository paymentRepository, OrderRepository orderRepository) {
        this.paymentGateway = paymentGateway;
        this.paymentRepository = paymentRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Order getOrder(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new NoSuchElementException("no order"));
    }

    @Override
    public void pay(Payment payment) {
        paymentGateway.execute(payment);
    }

    @Override
    public void save(Payment payment) {
        paymentRepository.save(payment);
    }

    @Override
    public void pay(int price, String cardNumber) {
        paymentGateway.execute(price, cardNumber);
    }
}
