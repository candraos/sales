package com.example.sales.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="clients")
@Data
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="client_id")
    private UUID id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "client")
    private List<Sale> sales = new ArrayList<Sale>();


}
