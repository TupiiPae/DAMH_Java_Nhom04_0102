package com.vanlang.DAMH_Nhom04_0102.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String file;
    private String price;
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}