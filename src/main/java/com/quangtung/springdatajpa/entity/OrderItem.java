package com.quangtung.springdatajpa.entity;
import com.quangtung.springdatajpa.transfrom.OrderTransform;
import lombok.*;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Float price;
    private int quantity;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

    @Override
    public String toString() {
        ModelMapper modelMapper = new ModelMapper();
        OrderTransform orderTransform = modelMapper.map(order,OrderTransform.class);

        return "OrderItem{" +
                "id=" + id +
                ", price=" + price +
                ", quantity=" + quantity +
                ", product=" + product +
                ", order=" + orderTransform +
                '}';
    }
}
