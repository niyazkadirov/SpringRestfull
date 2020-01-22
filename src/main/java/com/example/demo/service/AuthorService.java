package com.example.demo.service;

import com.example.demo.dao.AuthorRepository;
import com.example.demo.domain.Author;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public AuthorService() {
    }

    public Author getAuthor(Long id) throws ResourceNotFoundException {
        return authorRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Author not found for this id :: " + id));
    }

    public List<Author> getAllAuthor() {
        return authorRepository.findAll();
    }

    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    public void updateAuthor(Author author, Long id) {
        author.setId(id);
        authorRepository.save(author);
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

}
