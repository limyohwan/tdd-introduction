package com.example.productorderservice.product;

import org.springframework.util.Assert;

class UpdateProductRequest {
    private final String name;
    private final int price;
    private final DiscountPolicy discountPolicy;

    public UpdateProductRequest(String name, int price, DiscountPolicy discountPolicy) {
        Assert.isTrue(price > 0, "상품 가격은 0보다 커야 합니다.");
        Assert.hasText(name, "상품명은 필수입니다.");
        Assert.notNull(discountPolicy, "할인 정책은 필수 입니다.");
        this.name = name;
        this.price = price;
        this.discountPolicy = discountPolicy;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public DiscountPolicy getDiscountPolicy() {
        return discountPolicy;
    }
}
