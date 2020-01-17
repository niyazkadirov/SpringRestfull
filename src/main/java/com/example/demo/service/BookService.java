package com.example.demo.service;

import com.example.demo.DTO.BookDTO;
import com.example.demo.dao.BookRepository;
import com.example.demo.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public BookService() {
    }

    public List<BookDTO> getBook(Long id) {
        BookDTO bookDTO = new BookDTO();
        return bookDTO.getBookDTOList(bookRepository.findById(id));
    }

    public List<Book> getAllBook() {
        return bookRepository.findAll();

    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public void updateBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

}
