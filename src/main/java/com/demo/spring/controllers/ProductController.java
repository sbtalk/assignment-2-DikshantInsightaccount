package com.demo.spring.controllers;

import com.demo.spring.entities.Product;
import com.demo.spring.services.ProductService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping(path= "/getAllProducts",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping(path = "/getById/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        return ResponseEntity.ok(productService.getSingleProductById(id));
    }

    @PostMapping(path = "/addProduct",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> addProduct(@RequestBody Product p){ return ResponseEntity.ok(productService.save(p));

    }

    @GetMapping(path = "/category/{category}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> getUsingCategory(@PathVariable String category){
        return ResponseEntity.ok(productService.findUsingCategory(category));
    }

    @GetMapping(path = "/priceLessThan/{price}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> getProductsCheaperThan(@PathVariable Double price) {
        return ResponseEntity.ok(productService.findCheaperThan(price));
    }

}
