package com.quangtung.springdatajpa.repository;

import com.quangtung.springdatajpa.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {
}
