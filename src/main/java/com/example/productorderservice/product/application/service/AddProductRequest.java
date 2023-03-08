package com.example.productorderservice.product.application.service;

import com.example.productorderservice.product.domain.DiscountPolicy;
import org.springframework.util.Assert;

public class AddProductRequest {
    private final String name;
    private final int price;
    private final DiscountPolicy discountPolicy;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public DiscountPolicy getDiscountPolicy() {
        return discountPolicy;
    }

    public AddProductRequest(String name, int price, DiscountPolicy discountPolicy) {
        Assert.hasText(name, "상품명은 필수입니다.");
        Assert.isTrue(price > 0, "상품 가격은 0보다 커야합니다.");
        Assert.notNull(discountPolicy, "할인 정책은 필수 입니다.");
        this.name = name;
        this.price = price;
        this.discountPolicy = discountPolicy;
    }
}
