package com.demo.spring.exceptions;

public class ProductNotFoundException extends ProductResourceException{
    public ProductNotFoundException(){}

    public ProductNotFoundException(String message){
        super(message);
    }
}
