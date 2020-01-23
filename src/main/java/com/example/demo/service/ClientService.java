package com.example.demo.service;

import com.example.demo.dao.ClientRepository;
import com.example.demo.dao.OrderRepository;
import com.example.demo.domain.Client;
import com.example.demo.domain.Oder;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private OrderRepository orderRepository;


    private static LocalDateTime parseStringToLocalDateTime(String dateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
        return LocalDateTime.parse(dateTime, formatter);
    }

    public Client getClient(Long id) throws ResourceNotFoundException {
        return clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found for this id :: " + id));
    }

    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }

    public void createClient(Client client) {
        clientRepository.save(client);
    }

    public void updateClient(Client client, Long id) throws ResourceNotFoundException {
        getClient(id);
        client.setId(id);
        clientRepository.save(client);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    public List<Oder> getOrdersAndClientByPeriod(String starDateTime,
                                             String endDateTime){

       return orderRepository.findByCreatedAtBetween(parseStringToLocalDateTime(starDateTime),
                                                    parseStringToLocalDateTime(endDateTime));
    }
}
