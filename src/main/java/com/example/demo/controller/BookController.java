package com.example.demo.controller;

import com.example.demo.domain.Book;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.BookService;
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
    @ApiOperation(value = "Get the book and his author", response = List.class)
    @ResponseBody
    public Book getBook(@PathVariable("id") Long id) throws ResourceNotFoundException {
        return this.bookService.getBook(id)
                        .orElseThrow(()-> new ResourceNotFoundException("Author not found for this id :: " + id));
    }


    @RequestMapping(value = "",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get all books and his authors", response = List.class)
    @ResponseBody
    public List<Book> getAllBook() {
        return this.bookService.getAllBook();
    }


    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes = {"application/json"},
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Create book", response = void.class)
    @ResponseBody
    public void createBook(@RequestBody Book book) {
        this.bookService.createBook(book);
    }


    @RequestMapping(value = "/{id}",
            method = RequestMethod.PUT,
            consumes = {"application/json"},
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Update book", response = void.class)
    @ResponseBody
    public void updateBook(@PathVariable("id") Long id, @RequestBody Book book) {
        this.bookService.updateBook(book, id);
    }


    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete book", response = void.class)
    @ResponseBody
    public void deleteBook(@PathVariable("id") Long id) {
        this.bookService.deleteBook(id);
    }


}
