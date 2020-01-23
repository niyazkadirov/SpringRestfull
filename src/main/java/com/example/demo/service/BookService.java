package com.example.demo.service;

import com.example.demo.dao.BookRepository;
import com.example.demo.domain.Book;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public BookService() {
    }

    public Book getBook(Long id) throws ResourceNotFoundException {
        return this.bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found for this id :: " + id));
    }

    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    public void createBook(Book book) {
        bookRepository.save(book);
    }

    public void updateBook(Book book, Long id) throws ResourceNotFoundException {
        getBook(id);
        book.setId(id);
        bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

}
