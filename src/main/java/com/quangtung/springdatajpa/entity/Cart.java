package com.quangtung.springdatajpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "carts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total_price")
    private Float totalPrice;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "cart",fetch = FetchType.EAGER)
    private Set<CartItem> cartItems = new HashSet<>();

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Float getTotalAmount(){
        Float amount = 0f;
        for(CartItem item: this.cartItems){
            if(item.getActive()==true){
                amount += item.getTotalPrice();
            }
        }
        return amount;
    }
}
