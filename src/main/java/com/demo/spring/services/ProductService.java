package com.demo.spring.services;

import com.demo.spring.entities.Product;
import com.demo.spring.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){return this.productRepository.findAll();}

    public Product getSingleProductById(Long id){
        Optional<Product> productOptional =productRepository.findById(id);
        if(productOptional.isPresent()){
            return productOptional.get();
        }
        else{
            throw new RuntimeException();
        }

    }

    public Product save(Product p){
        return productRepository.save(p);
    }

    public List<Product> findUsingCategory(String category){
        return productRepository.findByCategory(category);
    }
    public List<Product> findCheaperThan(Double price) {
        return productRepository.findByPriceLessThan(price);
    }
}
