package com.example.productorderservice.order;

import com.example.productorderservice.order.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
class OrderRepositoryOld {
    private Map<Long, Order> persistence = new HashMap<>();
    private Long sequence = 0L;

    public void save(Order order) {
        order.assignId(++sequence);
        persistence.put(order.getId(), order);
    }
}
