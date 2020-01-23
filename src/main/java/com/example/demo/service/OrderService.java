package com.example.demo.service;

import com.example.demo.dao.BookRepository;
import com.example.demo.dao.ClientRepository;
import com.example.demo.dao.OrderRepository;
import com.example.demo.domain.Book;
import com.example.demo.domain.Client;
import com.example.demo.domain.Oder;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientService clientService;

    @Autowired
    private BookService bookService;


    public Oder getOrder(Long id) throws ResourceNotFoundException {
        return orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + id));
    }

    public List<Oder> getAllOrder() {
        return orderRepository.findAll();
    }

    public void createOrder(Oder oder) {
        oder.setFlagExecution(false);
        this.orderRepository.save(oder);
    }

    public void updateOrder(Oder oder, Long id) throws ResourceNotFoundException {
        getOrder(id);
        oder.setId(id);
        oder.setFlagExecution(false);
        orderRepository.save(oder);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }


    public void executeOrder(Long oderId, Long clientId, Long bookId) throws ResourceNotFoundException {
        Oder oder = getOrder(oderId);
        oder.setFlagExecution(true);
        oder.setFlagExecutionDate(LocalDateTime.now());

        Client client = clientService.getClient(clientId);
        client.setOder(oder);

        Book book = bookService.getBook(bookId);
        book.setOder(oder);

        this.clientRepository.save(client);
        this.bookRepository.save(book);
        this.orderRepository.save(oder);
    }
}
