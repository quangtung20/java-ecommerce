package com.quangtung.springdatajpa.service.impl;

import com.quangtung.springdatajpa.entity.Cart;
import com.quangtung.springdatajpa.entity.User;
import com.quangtung.springdatajpa.exception.UserNotFoundException;
import com.quangtung.springdatajpa.payload.UserDto;
import com.quangtung.springdatajpa.repository.UserRepository;
import com.quangtung.springdatajpa.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto)  {
        Optional<User> user = userRepository.findFirstByEmail(userDto.getEmail());
        if(user.isPresent()){
            throw new UserNotFoundException("User does not exist");
        }
        User newUser = modelMapper.map(userDto,User.class);
        Cart cart = new Cart();
        cart.setUser(newUser);
        newUser.setCart(cart);
        User savedUser = userRepository.save(newUser);
        return (modelMapper.map(savedUser,UserDto.class));
    }

    @Override
    public List<UserDto> getAllUsers() {
        return null;
    }

    @Override
    public UserDto getUserById(Long id) {
        return null;
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        return null;
    }

    @Override
    public String deleteUser(Long id) {
        return null;
    }
}
