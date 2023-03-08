package com.example.productorderservice.product;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void update() {
        Product product = new Product("상품명", 1000, DiscountPolicy.NONE);
        product.update("상품 수정", 2000, DiscountPolicy.NONE);
        Assertions.assertThat(product.getName()).isEqualTo("상품 수정");
    }
}