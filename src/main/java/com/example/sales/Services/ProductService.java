package com.example.sales.Services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sales.Models.Product;
import com.example.sales.Repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;


    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public Product editProduct(Product product, UUID id){
        Optional<Product> productToEdit = productRepository.findById(id);
        if(productToEdit.isPresent()){
            product.setId(id);
           return  productRepository.save(product);
        }
        return null;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

}
