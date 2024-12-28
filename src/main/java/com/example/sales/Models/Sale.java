package com.example.sales.Models;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="sale_id")
    private UUID id;

    @Column(name="creation_date")
    private LocalDate creationDate;

    @Column(name="total")
    private double total;

    @ManyToOne
    @JoinColumn(name="client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;
}
