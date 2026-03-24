package com.demo.spring.exceptions;

import com.demo.spring.entities.Product;

public class ProductResourceException extends RuntimeException {
    public ProductResourceException(){

    }

    public ProductResourceException(String message){
        super(message);
    }
}

