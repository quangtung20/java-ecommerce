package com.quangtung.springdatajpa.repository;

import com.quangtung.springdatajpa.entity.Product;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {
    @Autowired
    private ProductRepository  productRepository;

    @Test
    @DisplayName("Test save product")
    void saveProduct() {
        Product newProduct = Product.builder()
                .name("product2")
                .active(true)
                .price(200f)
                .sku("100ABC2")
                .description("haha")
                .imageUrl("product2.png")
                .build();

        Product saveProduct = productRepository.save(newProduct);

        System.out.println("saveProductId = " + saveProduct.getId());
        System.out.println(saveProduct.toString());

        Assertions.assertThat(saveProduct).isNotNull();
    }

    @Test
    @DisplayName("Test for update product")
    void updateUsingSaveMethod(){
        Long id = 1L;
        Product product = productRepository.findById(id).get();

        product.setName("Le");
        product.setPrice(200f);

        Product updatedProduct = productRepository.save(product);

        Assertions.assertThat(updatedProduct.getName()).isEqualTo("Le");
    }

    @Test
    @DisplayName("Test for find method")
    void getProductByName(){
        Optional<Product> product = productRepository.findByName("nam");
        System.out.println("product = " + product);
    }
    
    @Test
    @DisplayName("Test for find or")
    void getProductByNameOrDescription(){
        List<Product> products = productRepository.findByNameOrDescription("tung","haha");
        System.out.println("products = " + products);
    }

    @Test
    @DisplayName("find by name and description")
    void getProductByNameAndDescription(){
        List<Product> products = productRepository.findByNameAndDescription("tung","haha");
        Assertions.assertThat(products.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("find distinct by name")
    void getProductByDistinctName(){
        Product product = productRepository.findDistinctByName("Le");
        System.out.println("product = " + product);
    }

    @Test
    @DisplayName("find by name containing")
    void getProductByImageUrlLike(){
        List<Product> product = productRepository.findByImageUrlContaining("product");
    }

    @Test
    @DisplayName("find by imageUrl like")
    void getProductByImageUrlLike2(){
        List<Product> product = productRepository.findByImageUrlLike("product");
    }

    @Test
    @DisplayName("find by imageUrl")
    void getFirstProductByImageUrl(){
        Product product = productRepository.findFirstByImageUrl("prod");
    }

    @Test
    @DisplayName("find by greater than ")
    void getProductGreaterThanPrice(){
        List<Product> products = productRepository.findByPriceGreaterThan(new BigDecimal(80));
        System.out.println("products = " + products);
    }
    
    @Test
    @DisplayName("find by name in")
    void getProductByNameIn(){
        List<Product> products = productRepository.findByNameInOrderByNameDesc(List.of("product2","le"));
        System.out.println("products = " + products);
    }

    @Test
    @DisplayName("find by product")
    void getProductByNameJPLQ(){
        List<Product> products = productRepository.findProductBynameJPQL("Le","haha");
    }
    
    @Test
    @DisplayName("find by jpql param")
    void getProductByNameJPQLParam(){
        List<Product> products = productRepository.findProductByJPQLParam("Le","haha");
        System.out.println("products = " + products);
    }

    @Test
    @DisplayName("find by native query")
    void getProductByNativeQuery(){
        List<Product> products = productRepository.findProductByNativeQL("Le","haha");
        System.out.println("products = " + products);
    }

}