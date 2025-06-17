package com.micfro.univappbespringmainrepo.service;


import com.micfro.univappbespringmainrepo.entity.Product;
import com.micfro.univappbespringmainrepo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
//@RequiredArgsConstructor // Lombok: tworzy konstruktor dla pól final
@Transactional // Wszystkie publiczne metody będą transakcyjne
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    // CREATE
    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }


    // READ ALL
    @Override
    @Transactional(readOnly = true) // Optymalizacja dla zapytań tylko do odczytu
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


//    @Override
//    @Transactional(readOnly = true)
//    public Optional<Product> getProductById(Long id) {
//        return productRepository.findById(id);
//    }
//


//
//    @Override
//    public Product updateProduct(Long id, Product productDetails) {
//        Product existingProduct = productRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Nie znaleziono produktu o id: " + id));
//
//        existingProduct.setName(productDetails.getName());
//        existingProduct.setDescription(productDetails.getDescription());
//        existingProduct.setPrice(productDetails.getPrice());
//        existingProduct.setStockQuantity(productDetails.getStockQuantity());
//        existingProduct.setImageUrl(productDetails.getImageUrl());
//        existingProduct.setAvailable(productDetails.isAvailable());
//        // Pola audytowe są aktualizowane automatycznie przez @EntityListeners
//
//        return productRepository.save(existingProduct);
//    }
//
//    @Override
//    public void deleteProduct(Long id) {
//        if (!productRepository.existsById(id)) {
//            throw new RuntimeException("Nie znaleziono produktu o id: " + id);
//        }
//        productRepository.deleteById(id);
//    }
//
}


