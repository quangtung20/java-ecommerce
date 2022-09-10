package com.quangtung.springdatajpa.repository;

import com.quangtung.springdatajpa.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
    Order findOrderByOrderTrackingNumber(String orderTrackingNumber);
}
