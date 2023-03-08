package com.example.productorderservice.product.application.port;

import com.example.productorderservice.product.domain.Product;

public interface ProductPort {
    void save(Product product);

    Product getProduct(Long productId);
}
