package com.quangtung.springdatajpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cart_items")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Float totalPrice;

    private int quantity;

    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "product_id",referencedColumnName = "id" )
    private Product product;

    @ManyToOne
    @JoinColumn(name = "cart_id",referencedColumnName = "id" )
    private Cart cart;

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", totalPrice=" + totalPrice +
                ", quantity=" + quantity +
                ", active=" + active +
                ", product=" + product +
                '}';
    }
}
