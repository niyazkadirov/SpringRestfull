package com.example.demo.controller;

import com.example.demo.domain.Oder;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/order")
@Api(tags = {"Order"})
public class OrderController {

    @Autowired
    private OrderService orderService;


    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Получить заказ по id", response = Oder.class)
    @ResponseBody
    public Oder getOrder(@PathVariable("id") Long id) throws ResourceNotFoundException {
        return this.orderService.getOrder(id);
    }

    @RequestMapping(value = "",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Получить все заказы", response = List.class)
    @ResponseBody
    public List<Oder> getAllOrder() {
        return this.orderService.getAllOrder();
    }


    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes = {"application/json"},
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Создать заказ", response = void.class)
    @ResponseBody
    public void createOrder(@RequestBody Oder oder) {
        this.orderService.createOrder(oder);
    }


    @RequestMapping(value = "/{id}",
            method = RequestMethod.PUT,
            consumes = {"application/json"},
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Обновить заказ", response = void.class)
    @ResponseBody
    public void updateOrder(@PathVariable Long id, @RequestBody Oder oder) throws ResourceNotFoundException {
        this.orderService.updateOrder(oder, id);
    }


    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Удалить заказ", response = void.class)
    @ResponseBody
    public void deleteOrder(@PathVariable("id") Long id) throws ResourceNotFoundException {
        Oder order = getOrder(id);
        this.orderService.deleteOrder(order.getId());
    }


    @RequestMapping(value = "/{oderId}/{clientId}/{bookId}",
            method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Выполнить заказ", response = void.class)
    public void executeOrder(@PathVariable Long oderId,
                             @PathVariable Long clientId,
                             @PathVariable Long bookId) throws ResourceNotFoundException {

        this.orderService.executeOrder(oderId, clientId, bookId);
    }

}

