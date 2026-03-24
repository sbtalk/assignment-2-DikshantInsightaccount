package com.demo.spring.exceptions;

import com.demo.spring.util.ResponseMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResponseMessage> handle(ProductResourceException e){
    return ResponseEntity.status(400).body(new ResponseMessage(e.getMessage()));
    }
}
