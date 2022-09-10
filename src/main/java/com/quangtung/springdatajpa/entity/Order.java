package com.quangtung.springdatajpa.entity;

import com.quangtung.springdatajpa.transfrom.AddressTransform;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_tracking_number")
    private String orderTrackingNumber;

    @Column(name = "total_quantity")
    private int totalQuantity;

    @Column(name = "total_price")
    private Float totalPrice;

    @Column(name = "status")
    private String status;

    @Column(name = "date_created")
    @CreationTimestamp
    private Date dateCreated;

    @Column(name = "last_updated")
    @CreationTimestamp
    private Date lastUpdated;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "order")
    private Address billingAddress;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "order",fetch = FetchType.EAGER)
    private Set<OrderItem> orderItems = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;


    public Float getTotalAmount(){
        Float amount = 0f;
        for(OrderItem item: this.orderItems){
            amount += item.getPrice();
        }
        return amount;
    }

    @Override
    public String toString() {
        AddressTransform addressTransform = AddressTransform.builder()
                .id(billingAddress.getId())
                .city(billingAddress.getCity())
                .street(billingAddress.getStreet())
                .state(billingAddress.getState())
                .country(billingAddress.getCountry())
                .zipCode(billingAddress.getZipCode())
                .build();
        return "Order{" +
                "id=" + id +
                ", orderTrackingNumber='" + orderTrackingNumber + '\'' +
                ", totalQuantity=" + totalQuantity +
                ", totalPrice=" + totalPrice +
                ", status='" + status + '\'' +
                ", dateCreated=" + dateCreated +
                ", lastUpdated=" + lastUpdated +
                ", billingAddress=" + addressTransform +
                ", orderItems=" + orderItems +
                ", user=" + user +
                '}';
    }
}
