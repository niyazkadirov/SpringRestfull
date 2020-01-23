package com.example.demo.controller;

import com.example.demo.domain.Book;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.BookService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/book")
@Api(tags = {"Book"})

public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Получить книгу по id", response = List.class)
    @ResponseBody
    public Book getBook(@PathVariable("id") Long id) throws ResourceNotFoundException {
        return this.bookService.getBook(id);
    }


    @RequestMapping(value = "",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Получить все книги", response = List.class)
    @ResponseBody
    public List<Book> getAllBook() {
        return this.bookService.getAllBook();
    }

    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes = {"application/json"},
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Создать книгу", response = void.class)
    @ResponseBody
    public void createBook(@RequestBody Book book) {
        this.bookService.createBook(book);
    }


    @RequestMapping(value = "/{id}",
            method = RequestMethod.PUT,
            consumes = {"application/json"},
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Обновить книгу", response = void.class)
    @ResponseBody
    public void updateBook(@PathVariable("id") Long id, @RequestBody Book book) throws ResourceNotFoundException {
        this.bookService.updateBook(book, id);
    }


    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Удалить книгу", response = void.class)
    @ResponseBody
    public void deleteBook(@PathVariable("id") Long id) throws ResourceNotFoundException {
        Book book = getBook(id);
        this.bookService.deleteBook(book.getId());
    }


}
