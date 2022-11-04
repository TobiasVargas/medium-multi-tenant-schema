package com.medium.multitenant.demo.controller;

import com.medium.multitenant.demo.model.Product;
import com.medium.multitenant.demo.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping(path = "/products")
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(
                this.productRepository.findAll()
        );
    }

    @PostMapping(path = "/products")
    public ResponseEntity<Product> save(@RequestBody Product product) {
        return ResponseEntity.ok(
                this.productRepository.save(product)
        );
    }
}
