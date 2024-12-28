package com.example.sales.Controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sales.Models.Sale;
import com.example.sales.Services.SaleService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/sale")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Sale>> getAll(){
        List<Sale> sales = saleService.getAllSales();
        return new ResponseEntity<>(sales,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Sale> createSale(@RequestBody Sale sale){
        Sale createdSale = saleService.createSale(sale);
        return new ResponseEntity<>(createdSale,HttpStatus.CREATED);
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<Sale> editSale(@RequestBody Sale sale,@PathVariable UUID id){
        Sale saleEdited = saleService.editSale(sale, id);
        return new ResponseEntity<>(saleEdited,saleEdited == null ? HttpStatus.NOT_ACCEPTABLE : HttpStatus.ACCEPTED );
    }

}
