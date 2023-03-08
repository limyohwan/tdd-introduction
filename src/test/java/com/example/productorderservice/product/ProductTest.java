package com.example.productorderservice.product;

import com.example.productorderservice.product.domain.DiscountPolicy;
import com.example.productorderservice.product.domain.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductTest {

    @Test
    void update() {
        Product product = new Product("상품명", 1000, DiscountPolicy.NONE);
        product.update("상품 수정", 2000, DiscountPolicy.NONE);
        Assertions.assertThat(product.getName()).isEqualTo("상품 수정");
        Assertions.assertThat(product.getPrice()).isEqualTo(2000);

    }

    @Test
    void none_discounted_product() {
        Product product = new Product("상품명", 1000, DiscountPolicy.NONE);
        int discountedPrice = product.getDiscountedPrice();

        Assertions.assertThat(discountedPrice).isEqualTo(1000);
    }

    @Test
    void fix_1000_discounted_product() {
        Product product = new Product("상품명", 2000, DiscountPolicy.FIX_1000_AMOUNT);
        int discountedPrice = product.getDiscountedPrice();

        Assertions.assertThat(discountedPrice).isEqualTo(1000);
    }

    @Test
    void over_discounted_product() {
        Product product = new Product("상품명", 500, DiscountPolicy.FIX_1000_AMOUNT);
        int discountedPrice = product.getDiscountedPrice();

        Assertions.assertThat(discountedPrice).isEqualTo(0);
    }
}