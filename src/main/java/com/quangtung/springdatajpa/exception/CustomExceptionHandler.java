package com.quangtung.springdatajpa.exception;

import com.quangtung.springdatajpa.payload.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ResponseDto> handleUserNotFoundException(UserNotFoundException e, WebRequest req){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ResponseDto("failed","The product name has already exists","")
        );
    }
}
