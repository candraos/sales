package com.example.sales.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sales.Models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client,UUID>{

}
