package com.quangtung.springdatajpa.service;

import com.quangtung.springdatajpa.payload.UserDto;

import java.util.List;

public interface UserService {
    public UserDto createUser(UserDto userDto);
    public List<UserDto> getAllUsers();
    public UserDto getUserById(Long id);
    public UserDto updateUser(UserDto userDto);
    public String deleteUser(Long id);
}
