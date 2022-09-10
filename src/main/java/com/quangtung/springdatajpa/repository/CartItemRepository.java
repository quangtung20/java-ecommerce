package com.quangtung.springdatajpa.repository;

import com.quangtung.springdatajpa.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {
}
