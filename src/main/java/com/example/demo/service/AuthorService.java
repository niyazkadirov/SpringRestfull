package com.example.demo.service;

import com.example.demo.dao.AuthorRepository;
import com.example.demo.domain.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public AuthorService() {
    }

    public Optional<Author> getAuthor(Long id) {
        return authorRepository.findById(id);
    }

    public List<Author> getAllAuthor() {
        return authorRepository.findAll();
    }

    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    public void updateAuthor(Author author) {
        authorRepository.save(author);
    }

    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

}
