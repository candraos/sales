package com.example.sales.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sales.Models.Sale;

public interface SaleRepository extends JpaRepository<Sale,UUID>{

}
