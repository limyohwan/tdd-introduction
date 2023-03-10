package com.example.productorderservice.product;

import com.example.productorderservice.product.application.service.GetProductResponse;
import com.example.productorderservice.product.application.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class ProductServiceTest2 {
    @Autowired
    private ProductService productService;
    @Test
    void 상품조회(){
        //상품등록
        productService.addProduct(ProductSteps.상품등록요청_생성());
        final long productId = 1L;
        //상품 조회
        ResponseEntity<GetProductResponse> response = productService.getProduct(productId);
        //상품의 응답을 검증
        assertThat(response).isNotNull();
    }

}
