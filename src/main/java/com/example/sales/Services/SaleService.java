package com.example.sales.Services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sales.Models.Sale;
import com.example.sales.Repositories.SaleRepository;

@Service
public class SaleService {


    @Autowired
    private SaleRepository saleRepository;

    public List<Sale> getAllSales(){
        return saleRepository.findAll();
    }

    public Sale createSale(Sale sale){
        return saleRepository.save(sale);
    }

    public Sale editSale(Sale sale,UUID id){
        Optional<Sale> saleToEdit = saleRepository.findById(id);
        if(saleToEdit.isPresent()){
            sale.setId(id);
            return saleRepository.save(sale);
        }
        return null;
    }
}
