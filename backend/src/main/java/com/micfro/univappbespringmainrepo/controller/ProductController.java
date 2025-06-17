package com.micfro.univappbespringmainrepo.controller;


import com.micfro.univappbespringmainrepo.entity.Product;
import com.micfro.univappbespringmainrepo.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {


    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    // CRUD OPERATIONS

    // CREATE
    // POST /api/products - tworzy nowy produkt
    @PostMapping("/api/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }


    // READ ALL
    // GET /api/products
    @GetMapping("/api/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }


    // READ BY ID


    // UPDATE BY ID

    // DELETE BY ID


}
