package com.example.productorderservice.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

public class ProductServiceTest3 {
    private ProductService productService;
    private ProductPort productPort;
    private ProductRepository productRepository;
    @BeforeEach
    void setUp() {
        productRepository = new ProductRepository();
        productPort = new ProductAdapter(productRepository);
        productService = new ProductService(productPort);
    }

    @Test
    void 상품등록(){
        final String name = "상품명";
        final int price = 1000;
        final DiscountPolicy discountPolicy = DiscountPolicy.NONE;
        final AddProductRequest request = new AddProductRequest(name, price, discountPolicy);

        productService.addProduct(request);
    }

    private class ProductService{
        private final ProductPort productPort;
        public ProductService(ProductPort productPort){
            this.productPort = productPort;
        }
        public void addProduct(final AddProductRequest request){
            final Product product = new Product(request.getName(), request.getPrice(), request.getDiscountPolicy());
            productPort.save(product);
        }
    }

    private class AddProductRequest {
        private final String name;
        private final int price;
        private final DiscountPolicy discountPolicy;

        public AddProductRequest(final String name, final int price, final DiscountPolicy discountPolicy){
            Assert.hasText(name, "상품명은 필수입니다.");
            Assert.isTrue(price > 0, "상품 가격은 0보다 커야합니다.");
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

    private enum DiscountPolicy {
        NONE
    }

    private class Product {
        private Long id;
        private String name;
        private int price;
        private DiscountPolicy discountPolicy;
        public Product(final String name, final int price, final DiscountPolicy discountPolicy){
            Assert.hasText(name, "상품명은 필수입니다.");
            Assert.isTrue(price > 0, "상품 가격은 0보다 커야합니다.");
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

        public Long getId() {
            return id;
        }

        public void assignId(final Long id) {
            this.id = id;
        }
    }

    private interface ProductPort {
        void save(final Product product);
    }

    private class ProductAdapter implements ProductPort{
        private ProductRepository productRepository;

        private ProductAdapter(ProductRepository productRepository) {
            this.productRepository = productRepository;
        }

        @Override
        public void save(Product product) {
            productRepository.save(product);
        }
    }

    private class ProductRepository {
        private Map<Long, Product> persistence = new HashMap<>();
        private Long sequence = 0L;
        public void save(final Product product){
            product.assignId(++sequence);
            persistence.put(product.getId(), product);
        }
    }
}
