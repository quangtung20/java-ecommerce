package com.quangtung.springdatajpa.repository;

import com.quangtung.springdatajpa.entity.Address;
import com.quangtung.springdatajpa.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class OneToOneUnindirectional {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private AddressRepository addressRepository;

    @Test
    void saveOrder(){
        Address billingAddress = Address.builder()
                .city("da nang")
                .country("viet nam")
                .state("delivered")
                .zipCode("550000")
                .street("tan tra")
                .build();

        Order order = Order.builder()
                .orderTrackingNumber("11234")
                .totalQuantity(5)
                .totalPrice(100f)
                .status("delivered")
                .billingAddress(billingAddress)
                .build();

        orderRepository.save(order);
    }

    @Test
    void getOrderMethod(){
        List<Order> orders = orderRepository.findAll();
        System.out.println("orders = " + orders);
    }

    @Test
    void updateMethod(){
        Order order = orderRepository.findById(1L).get();
        order.setStatus("done");
        order.getBillingAddress().setState("done");
        Order updatedOrder = orderRepository.save(order);
        System.out.println("updatedOrder = " + updatedOrder);
    }

    @Test
    void deleteMethod(){
        orderRepository.deleteById(1L);
    }

    @Test
    void saveAddressMethod(){

        Order order = new Order();
        order.setOrderTrackingNumber("1000ABC");
        order.setTotalQuantity(5);
        order.setStatus("IN PROGRESS");
        order.setTotalPrice(1000f);

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
    void getOrderMethod2(){
        System.out.println("orderRepository = " + orderRepository.findById(2L));
        System.out.println("address = " + addressRepository.findById(2L));
    }
}
