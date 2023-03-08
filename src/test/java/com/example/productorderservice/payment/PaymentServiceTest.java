package com.example.productorderservice.payment;

import com.example.productorderservice.order.application.service.OrderService;
import com.example.productorderservice.order.OrderSteps;
import com.example.productorderservice.payment.application.service.PaymentRequest;
import com.example.productorderservice.payment.application.service.PaymentService;
import com.example.productorderservice.product.application.service.ProductService;
import com.example.productorderservice.product.ProductSteps;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PaymentServiceTest {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;
//    private PaymentPort paymentPort;

//    @BeforeEach
//    void setUp() {
//        PaymentGateway paymentGateway = new ConsolePaymentGateway();
//        PaymentRepository paymentRepository = new PaymentRepository();
//        paymentPort = new PaymentAdapter(paymentGateway, paymentRepository);
//        paymentService = new PaymentService(paymentPort);
//    }

    @Test
    void 상품주문(){
        productService.addProduct(ProductSteps.상품등록요청_생성());
        orderService.createOrder(OrderSteps.상품주문요청_생성());
        PaymentRequest request = PaymentSteps.주문결제요청_생성();
        paymentService.payment(request);
    }

}
