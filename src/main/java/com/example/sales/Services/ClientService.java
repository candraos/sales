package com.example.sales.Services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sales.Models.Client;
import com.example.sales.Repositories.ClientRepository;

@Service
public class ClientService {

@Autowired
private ClientRepository clientRepository;


public Client createClient(Client client){
    return clientRepository.save(client);
}

public Client editClient(Client client, UUID id){
    Optional<Client> clientToEdit = clientRepository.findById(id);
    if(clientToEdit.isPresent()){
        client.setId(clientToEdit.get().getId());
        return clientRepository.save(client);
    }
    return null;
}

public List<Client> fetchClients(){
    return clientRepository.findAll();
}
}
