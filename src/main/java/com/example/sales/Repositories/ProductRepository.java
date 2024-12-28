package com.example.sales.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sales.Models.Product;

public interface ProductRepository extends JpaRepository<Product,UUID>{

}
