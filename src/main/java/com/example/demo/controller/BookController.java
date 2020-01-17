package com.example.demo.controller;

import com.example.demo.domain.Author;
import com.example.demo.domain.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Optional<Book> getBook(@PathVariable("id") Long id) {
        return this.bookService.getBook(id);
    }


    @RequestMapping(value = "",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Book> getAllBook() {
        return this.bookService.getAllBook();
    }


    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes = {"application/json"},
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void createBook(@RequestBody Book book) {
        this.bookService.createBook(book);
    }


    @RequestMapping(value = "/{id}",
            method = RequestMethod.PUT,
            consumes = {"application/json"},
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public void updateBook(@PathVariable("id") Long id, @RequestBody Book book) {
        this.bookService.updateBook(book);
    }


    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public void deleteBook(@PathVariable("id") Long id) {
        this.bookService.deleteBook(id);
    }


}
