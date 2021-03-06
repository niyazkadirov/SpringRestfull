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
    @ApiOperation(value = "Получить автора по 'id' и его книги", response = Author.class)
    @ResponseBody
    public Author getAuthor(@PathVariable("id") Long id) throws ResourceNotFoundException {
        return this.authorService.getAuthor(id);
    }

    @RequestMapping(value = "",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Получить всех авторов, и их книги", response = List.class)
    @ResponseBody
    public List<Author> getAllAuthor() {
        return this.authorService.getAllAuthor();
    }


    @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes = {"application/json"},
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Создать автора")
    @ResponseBody
    public void createAuthor(@RequestBody Author author) {
        this.authorService.createAuthor(author);
    }


    @RequestMapping(value = "/{id}",
            method = RequestMethod.PUT,
            consumes = {"application/json"},
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Обновить автора", response = void.class)
    @ResponseBody
    public void updateAuthor(@PathVariable Long id, @RequestBody Author author) throws ResourceNotFoundException {
        this.authorService.updateAuthor(author, id);
    }


    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Удалить автора", response = void.class)
    @ResponseBody
    public void deleteAuthor(@PathVariable("id") Long id) throws ResourceNotFoundException {
        this.authorService.deleteAuthor(id);
    }
}

