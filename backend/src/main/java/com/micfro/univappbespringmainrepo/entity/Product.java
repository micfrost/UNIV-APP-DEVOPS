package com.micfro.univappbespringmainrepo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

//    @Column(nullable = false)
    private String name;

//    @Lob // Oznacza, że pole może przechowywać duże obiekty, odpowiednie dla dłuższego opisu
    private String description;

//    @Column(nullable = false, precision = 10, scale = 2)
//    private BigDecimal price;

//    @Column(name = "stock_quantity", nullable = false)
//    private Integer stockQuantity;

//    @Column(name = "image_url")
//    private String imageUrl;

//    @Column(name = "is_available", nullable = false)
//    private boolean isAvailable = true;

    // Pola audytowe
//    @CreatedDate
//    @Column(name = "created_at", nullable = false, updatable = false)
//    private LocalDateTime createdAt;

//    @CreatedBy
//    @Column(name = "created_by", updatable = false)
//    private String createdBy;

//    @LastModifiedDate
//    @Column(name = "updated_at")
//    private LocalDateTime updatedAt;

//    @LastModifiedBy
//    @Column(name = "updated_by")
//    private String updatedBy;
}