package com.example.productorderservice.product;

import com.example.productorderservice.product.domain.DiscountPolicy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class DiscountPolicyTest {

    @Test
    void noneDiscountPolicy() {
        int price = 1000;
        int discountedPrice = DiscountPolicy.NONE.applyDiscount(price);

        Assertions.assertThat(discountedPrice).isEqualTo(price);
    }

    @Test
    void name() {
        int price = 2000;
        int discountedPrice = DiscountPolicy.FIX_1000_AMOUNT.applyDiscount(price);

        Assertions.assertThat(discountedPrice).isEqualTo(1000);
    }

    @Test
    void name2() {
        int price = 500;
        int discountedPrice = DiscountPolicy.FIX_1000_AMOUNT.applyDiscount(price);

        Assertions.assertThat(discountedPrice).isEqualTo(0);
    }
}