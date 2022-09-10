package com.quangtung.springdatajpa.repository;

import com.quangtung.springdatajpa.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@SpringBootTest
public class OneToManyUniTest {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    void saveOrderMethod(){
        User user = userRepository.findById(1L).get();
        Order order = new Order();
        order.setOrderTrackingNumber("100ABC");
        order.setStatus("In progress");
        order.setUser(user);


        // create order item 1
        OrderItem orderItem1 = new OrderItem();
        orderItem1.setProduct(productRepository.findById(1L).get());
        orderItem1.setQuantity(2);
        orderItem1.setPrice(orderItem1.getProduct().getPrice()*2);
        orderItem1.setOrder(order);
        order.getOrderItems().add(orderItem1);

        // create order item 2
        OrderItem orderItem2 = new OrderItem();
        orderItem2.setProduct(productRepository.findById(2L).get());
        orderItem2.setQuantity(3);
        orderItem2.setPrice(orderItem2.getProduct().getPrice()*2);
        orderItem2.setOrder(order);
        order.getOrderItems().add(orderItem2);

        order.setTotalPrice(order.getTotalAmount());
        order.setTotalQuantity(2);

        Address address = new Address();
        address.setCity("Pune");
        address.setStreet("Kothrud");
        address.setState("Maharashtra");
        address.setCountry("India");
        address.setZipCode("411047");

        order.setBillingAddress(address);
        address.setOrder(order);
        orderRepository.save(order);
    }

    @Test
    void fetchOrder(){
        Order order = orderRepository.findById(2L).get();
        System.out.println("order = " + order);
    }

}
