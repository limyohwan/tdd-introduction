package com.example.productorderservice.order;

import com.example.productorderservice.product.Product;
import org.springframework.util.Assert;

class Order {
    private final Product product;
    private final int quantity;
    private Long id;

    public Order(Product product, int quantity) {
        Assert.notNull(product, "상품은 필수입니다");
        Assert.isTrue(quantity > 0, "수량은 0보다 커야합니다");
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
