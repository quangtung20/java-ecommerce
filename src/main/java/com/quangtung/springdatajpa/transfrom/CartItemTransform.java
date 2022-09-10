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
public class CartItemTransform {
    private Long id;

    private BigDecimal totalPrice;

    private int quantity;

    private Boolean active;
}
