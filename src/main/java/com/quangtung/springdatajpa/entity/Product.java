package com.quangtung.springdatajpa.entity;

import com.quangtung.springdatajpa.transfrom.ProductCategoryTransform;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "products",
        schema = "ecommerce",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "sku_unique",
                        columnNames = "stock_keeping_unit"
                )
        }
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_generator"
    )
    @SequenceGenerator(
            name = "product_generator",
            sequenceName = "product_sequence_name"
    )
    private Long id;

    @Column(nullable = false, name = "stock_keeping_unit")
    private String sku;

    @Column(nullable = false)
    private String name;

    private String description;

    private String imageUrl;

    private Float price;

    private Boolean active;

    @CreationTimestamp
    private LocalDateTime dateCreated;

    @CreationTimestamp
    private LocalDateTime lastUpdated;

    @ManyToOne()
    @JoinColumn(name = "product_category_id",referencedColumnName = "id")
    private ProductCategory category;

    @Override
    public String toString() {
        ModelMapper modelMapper = new ModelMapper();
        ProductCategoryTransform productCategoryTransform = modelMapper.map(category,ProductCategoryTransform.class);
        return "Product{" +
                "id=" + id +
                ", sku='" + sku + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", price=" + price +
                ", active=" + active +
                ", dateCreated=" + dateCreated +
                ", lastUpdated=" + lastUpdated +
                ", category=" + productCategoryTransform +
                '}';
    }
}
