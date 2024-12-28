package com.example.sales.DTO;

import java.time.LocalDate;
import java.util.UUID;


import lombok.Data;

@Data
public class ProductDTO {
    
    private String name;

    private String description;

    private String category;

}
