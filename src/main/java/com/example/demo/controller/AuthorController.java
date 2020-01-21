package com.example.demo.controller;

import com.example.demo.domain.Author;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.AuthorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/author")
@Api(tags = {"Author"})
public class AuthorController {

    @Autowired
    private AuthorService authorService;


    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get the author and his books", response = Optional.class)
    @ResponseBody
    public Author getAuthor(@PathVariable("id") Long id) throws ResourceNotFoundException {
        return this.authorService.getAuthor(id);
    }

    @RequestMapping(value = "",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get all authors and his books", response = List.class)
    @ResponseBody
    public List<Author> getAllAuthor() throws Exception {
        return this.authorService.getAllAuthor();
    }


    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes = {"application/json"},
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Create author", response = void.class)
    @ResponseBody
    public void createAuthor(@RequestBody Author author) {
        this.authorService.createAuthor(author);
    }


    @RequestMapping(value = "{/id}",
            method = RequestMethod.PUT,
            consumes = {"application/json"},
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Update author", response = void.class)
    @ResponseBody
    public void updateAuthor(@RequestBody Author author) {
        this.authorService.updateAuthor(author);
    }


    @RequestMapping(value = "{/id}",
            method = RequestMethod.DELETE,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Delete author", response = void.class)
    @ResponseBody
    public void deleteAuthor(@PathVariable("/id") Long id) {
        this.authorService.deleteAuthor(id);
    }
}

