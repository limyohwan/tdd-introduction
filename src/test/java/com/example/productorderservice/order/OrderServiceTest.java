package com.example.productorderservice.order;

import com.example.productorderservice.product.DiscountPolicy;
import com.example.productorderservice.product.Product;
import com.example.productorderservice.product.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class OrderServiceTest {

    private OrderService orderService;
    private OrderPort orderPort;

    private OrderRepository orderRepository;

    @BeforeEach
    void setUp(){
        orderRepository = new OrderRepository();
        orderPort = new OrderPort() {
            @Override
            public Product getProductById(Long productId) {
                return new Product("상품명", 1000, DiscountPolicy.NONE);
            }

            @Override
            public void save(Order order) {
                orderRepository.save(order);
            }
        };
        orderService = new OrderService(orderPort);
    }

    @Test
    void 상품주문(){
        Long productId = 1L;
        int quantity = 2;
        CreateOrderRequest request = new CreateOrderRequest(productId, quantity);
        orderService.createOrder(request);
    }


    private static class CreateOrderRequest {
        private final Long productId;
        private final int quantity;

        public CreateOrderRequest(Long productId, int quantity) {
            Assert.notNull(productId, "상품 Id는 필수입니다");
            Assert.isTrue(quantity > 0 , "수량은 0보다 커야합니다");
            this.productId = productId;
            this.quantity = quantity;
        }

        public Long getProductId() {
            return productId;
        }

        public int getQuantity() {
            return quantity;
        }
    }

    private class OrderService {
        private final OrderPort orderPort;

        private OrderService(OrderPort orderPort) {
            this.orderPort = orderPort;
        }

        public void createOrder(CreateOrderRequest request) {
            Product product = orderPort.getProductById(request.getProductId());
            Order order = new Order(product, request.getQuantity());

            orderPort.save(order);
        }
    }

    private class OrderAdapter implements OrderPort {
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
        public void save(Order order){
            orderRepository.save(order);
        }
    }

    private class Order {
        private final Product product;
        private final int quantity;
        private Long id;

        public Order(Product product, int quantity) {
            Assert.notNull(product, "상품은 필수입니다");
            Assert.isTrue(quantity > 0 , "수량은 0보다 커야합니다");
            this.product = product;
            this.quantity = quantity;
        }

        public Product getProduct() {
            return product;
        }

        public int getQuantity() {
            return quantity;
        }

        public Long getId() {
            return id;
        }

        public void assignId(Long id) {
            this.id = id;
        }
    }

    private class OrderRepository {
        private Map<Long, Order> persistence = new HashMap<>();
        private Long sequence = 0L;
        public void save(Order order) {
            order.assignId(++sequence);
            persistence.put(order.getId(), order);
        }
    }

    private interface OrderPort {
        Product getProductById(Long productId);
        void save(Order order);
    }
}
