package com.quangtung.springdatajpa.repository;

import com.quangtung.springdatajpa.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Long> {
}
