package com.quangtung.springdatajpa.repository;

import com.quangtung.springdatajpa.entity.Cart;
import com.quangtung.springdatajpa.entity.CartItem;
import com.quangtung.springdatajpa.entity.Product;
import com.quangtung.springdatajpa.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CartRepositoryTest {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveCart(){
        Cart cart = new Cart();
        User user = userRepository.findById(1L).get();
        cart.setUser(user);

        CartItem cartItem1 = new CartItem();
        Product product = productRepository.findById(1L).get();
        cartItem1.setProduct(product);
        cartItem1.setQuantity(2);
        cartItem1.setActive(true);
        cartItem1.setTotalPrice(product.getPrice()*2);
        cartItem1.setCart(cart);
        cart.getCartItems().add(cartItem1);

        CartItem cartItem2 = new CartItem();
        Product product2 = productRepository.findById(2L).get();
        cartItem2.setProduct(product2);
        cartItem2.setQuantity(3);
        cartItem2.setActive(false);
        cartItem2.setTotalPrice(product2.getPrice()*3);
        cartItem2.setCart(cart);
        cart.getCartItems().add(cartItem2);

        cart.setTotalPrice(cart.getTotalAmount());
        cartRepository.save(cart);
        System.out.println("cart = " + cart);
    }

}