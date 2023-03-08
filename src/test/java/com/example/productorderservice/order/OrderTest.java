package com.example.productorderservice.order;

import com.example.productorderservice.order.domain.Order;
import com.example.productorderservice.product.domain.DiscountPolicy;
import com.example.productorderservice.product.domain.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderTest {

    @Test
    void getTotalPrice() {
        Order order = new Order(new Product("상품명", 1000, DiscountPolicy.NONE), 2);
        int totalPrice = order.getTotalPrice();
        Assertions.assertThat(totalPrice).isEqualTo(2000);
    }
}