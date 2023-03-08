package com.example.productorderservice.order;

import com.example.productorderservice.product.Product;
import org.springframework.stereotype.Component;

@Component
class OrderService {
    private final OrderPort orderPort;

    OrderService(OrderPort orderPort) {
        this.orderPort = orderPort;
    }

    public void createOrder(CreateOrderRequest request) {
        Product product = orderPort.getProductById(request.getProductId());
        Order order = new Order(product, request.getQuantity());

        orderPort.save(order);
    }
}
