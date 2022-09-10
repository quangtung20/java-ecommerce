package com.quangtung.springdatajpa.repository;

import com.quangtung.springdatajpa.entity.Product;
import com.quangtung.springdatajpa.entity.ProductCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveProductCategory(){
//        Product product1 = productRepository.findById(1L).get();
//        Product product2 = productRepository.findById(2L).get();

        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryDescription("haha");
        productCategory.setCategoryName("category1");

        Product product1 = new Product();
        product1.setName("Core Java2");
        product1.setPrice(1000f);
        product1.setImageUrl("image2.png");
        product1.setSku("ABCDEZ");
        product1.setActive(true);
        product1.setCategory(productCategory);
        productCategory.getProducts().add(product1);

        Product product2 = new Product();
        product2.setName("Effective Java 2");
        product2.setPrice(2000f);
        product2.setImageUrl("image3.png");
        product2.setSku("ABCDEF");
        product2.setActive(true);
        product2.setCategory(productCategory);
        productCategory.getProducts().add(product2);

        productCategoryRepository.save(productCategory);
        System.out.println("productCategory = " + productCategory);
    }
}