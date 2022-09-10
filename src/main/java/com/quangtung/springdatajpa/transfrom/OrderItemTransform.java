package com.quangtung.springdatajpa.transfrom;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItemTransform {
    private long id;
    private String imageUrl;
    private BigDecimal price;
    private int quantity;
}
