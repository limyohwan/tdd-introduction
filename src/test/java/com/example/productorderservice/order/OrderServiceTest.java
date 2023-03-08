package com.example.productorderservice.order;

import com.example.productorderservice.order.application.service.CreateOrderRequest;
import com.example.productorderservice.order.application.service.OrderService;
import com.example.productorderservice.product.application.service.ProductService;
import com.example.productorderservice.product.ProductSteps;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

//    private OrderPort orderPort;
//    private OrderRepository orderRepository;

//    @BeforeEach
//    void setUp(){
//        orderRepository = new OrderRepository();
//        orderPort = new OrderPort() {
//            @Override
//            public Product getProductById(Long productId) {
//                return new Product("상품명", 1000, DiscountPolicy.NONE);
//            }
//
//            @Override
//            public void save(Order order) {
//                orderRepository.save(order);
//            }
//        };
//        orderService = new OrderService(orderPort);
//    }

    @Test
    void 상품주문(){
        productService.addProduct(ProductSteps.상품등록요청_생성());
        CreateOrderRequest request = 상품주문요청_생성();
        orderService.createOrder(request);
    }

    private static CreateOrderRequest 상품주문요청_생성() {
        Long productId = 1L;
        int quantity = 2;
        return new CreateOrderRequest(productId, quantity);
    }


}
