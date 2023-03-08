package com.example.productorderservice.order;

import com.example.productorderservice.product.DiscountPolicy;
import com.example.productorderservice.product.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void getTotalPrice() {
        Order order = new Order(new Product("상품명", 1000, DiscountPolicy.NONE), 2);
        int totalPrice = order.getTotalPrice();
        Assertions.assertThat(totalPrice).isEqualTo(2000);
    }
}