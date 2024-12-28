package com.example.sales.Models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="product_id")
    private UUID id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="category")
    private String category;

    @Column(name="creation_date")
    private LocalDate creationDate;

    @OneToMany(mappedBy = "product")
    private List<Sale> sales = new ArrayList<Sale>();
}
