package com.example.productorderservice.order.adapter;

import com.example.productorderservice.order.domain.Order;
import com.example.productorderservice.order.application.port.OrderPort;
import com.example.productorderservice.product.domain.Product;
import com.example.productorderservice.product.adapter.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
class OrderAdapter implements OrderPort {
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    private OrderAdapter(ProductRepository productRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Product getProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new NoSuchElementException("no such element"));
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }
}
