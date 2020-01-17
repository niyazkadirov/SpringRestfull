package com.example.demo.controller;

import com.example.demo.domain.Author;
import com.example.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Optional<Author> getAuthor(@PathVariable("id") Long id) {
       return this.authorService.getAuthor(id);
    }


    @RequestMapping(value = "",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Author> getAllAuthor() {
        return this.authorService.getAllAuthor();
    }


    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes = {"application/json"},
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void createAuthor(@RequestBody Author author) {
        this.authorService.createAuthor(author);
    }


    @RequestMapping(value = "{/id}",
            method = RequestMethod.PUT,
            consumes = {"application/json"},
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public void updateAuthor(@PathVariable("/id") Long id, @RequestBody Author author) {
        this.authorService.updateAuthor(author);
    }


    @RequestMapping(value = "{/id}",
            method = RequestMethod.DELETE,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public void deleteAuthor(@PathVariable("/id") Long id) {
        this.authorService.deleteAuthor(id);
    }


}

