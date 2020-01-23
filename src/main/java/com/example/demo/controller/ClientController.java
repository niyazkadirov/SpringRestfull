package com.example.demo.controller;

import com.example.demo.domain.Client;
import com.example.demo.domain.Oder;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/client")
@Api(tags = {"Client"})
public class ClientController {

    @Autowired
    private ClientService clientService;


    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Получить клиента по id", response = Client.class)
    @ResponseBody
    public Client getClient(@PathVariable("id") Long id) throws ResourceNotFoundException {
        return this.clientService.getClient(id);
    }


    @RequestMapping(value = "/{endDateTime}/{startDateTime}",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Получить заказы за указанный период")
    @ResponseBody
    public List<Oder> getOrdersAndClientByPeriod(@PathVariable("startDateTime") String startDateTime,
                                                 @PathVariable("endDateTime") String endDateTime) {
        return this.clientService.getOrdersAndClientByPeriod(startDateTime, endDateTime);
    }

    @RequestMapping(value = "",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Получить список клиентов", response = List.class)
    @ResponseBody
    public List<Client> getAllClient() {
        return this.clientService.getAllClient();
    }


    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes = {"application/json"},
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Создать клиента", response = void.class)
    @ResponseBody
    public void createClient(@RequestBody Client client) {
        this.clientService.createClient(client);
    }


    @RequestMapping(value = "/{id}",
            method = RequestMethod.PUT,
            consumes = {"application/json"},
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Обновить клиента", response = void.class)
    @ResponseBody
    public void updateClient(@PathVariable Long id, @RequestBody Client client) throws ResourceNotFoundException {
        this.clientService.updateClient(client, id);
    }


    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Удалить клиента", response = void.class)
    @ResponseBody
    public void deleteClient(@PathVariable("id") Long id) throws ResourceNotFoundException {
        Client client = getClient(id);
        this.clientService.deleteClient(client.getId());
    }

}

