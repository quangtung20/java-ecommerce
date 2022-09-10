package com.quangtung.springdatajpa.controller;

import com.quangtung.springdatajpa.exception.UserNotFoundException;
import com.quangtung.springdatajpa.payload.ResponseDto;
import com.quangtung.springdatajpa.payload.UserDto;
import com.quangtung.springdatajpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    ResponseEntity<ResponseDto> createUser(@RequestBody UserDto userDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new ResponseDto("created","insert product successfully",userService.createUser(userDto))
        );
    }

}
