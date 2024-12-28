package com.example.sales.Controllers;

import java.beans.JavaBean;
import java.util.List;
import java.util.UUID;

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

import com.example.sales.Models.Client;
import com.example.sales.Services.ClientService;

@RequestMapping("/client")
@RestController
@JavaBean
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/create")
    public ResponseEntity<Client> createClient(@RequestBody Client client){
        Client newClient = new Client();
        newClient = clientService.createClient(client);
        return new ResponseEntity<>(newClient,HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Client> editClient(@RequestBody Client client, @PathVariable UUID id){
        Client newClient = clientService.editClient(client, id);
        return new ResponseEntity<>(newClient,newClient == null ? HttpStatus.NOT_ACCEPTABLE : HttpStatus.ACCEPTED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Client>> getAllClients(){
        return new ResponseEntity<>(clientService.fetchClients(),HttpStatus.OK);
    }


}
