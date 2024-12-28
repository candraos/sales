package com.example.sales.Controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sales.DTO.ProductDTO;
import com.example.sales.Models.Product;
import com.example.sales.Services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/getAll")
    public ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity<>(productService.getAllProducts(),HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody ProductDTO productDto){
        Product product = modelMapper.map(productDto,Product.class);
        product.setCreationDate(LocalDate.now());
        System.out.println("local date >>>>>>>>>>>>>>>>>>>>> " + LocalDate.now());
        return new ResponseEntity<>(productService.createProduct(product),HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Product> ediProduct(@RequestBody Product product,@PathVariable UUID id){
        Product editedProduct = productService.editProduct(product, id);
        return new ResponseEntity<>(editedProduct,editedProduct == null ? HttpStatus.ACCEPTED : HttpStatus.NOT_FOUND);
    }
}
