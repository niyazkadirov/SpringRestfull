package com.example.demo.dao;

import com.example.demo.domain.Author;
import com.example.demo.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Override
    Optional<Book> findById(Long aLong);
}
