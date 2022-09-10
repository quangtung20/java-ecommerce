package com.quangtung.springdatajpa.transfrom;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductTransform {
    private Long id;

    private String sku;

    private String name;

    private String description;

    private String imageUrl;

    private BigDecimal price;

    private Boolean active;

    private LocalDateTime dateCreated;

    private LocalDateTime lastUpdated;
}
