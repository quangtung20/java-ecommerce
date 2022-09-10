package com.quangtung.springdatajpa.repository;

import com.quangtung.springdatajpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Optional<Product> findByName(String name);
    List<Product> findByNameOrDescription(String name,String description);
    List<Product> findByNameAndDescription(String name,String description);

    Product findDistinctByName(String name);

    List<Product> findByImageUrlContaining(String name);

    List<Product> findByImageUrlLike(String imageUrl);

    Product findFirstByImageUrl(String imageUrl);

    List<Product> findByPriceGreaterThan(BigDecimal price);

    List<Product> findByNameInOrderByNameDesc(List<String> nameList);

    @Query("select p from Product p where p.name = ?1 and p.description=?2")
    List<Product> findProductBynameJPQL(String name, String description);

    @Query("select p from Product p where p.name=:name and p.description=:description")
    List<Product> findProductByJPQLParam(@Param("name") String name, @Param("description") String description);

    @Query(value = "select * from products where products.name=:name and products.description=:description",nativeQuery = true)
    List<Product> findProductByNativeQL(@Param("name") String name, @Param("description") String description);


}
