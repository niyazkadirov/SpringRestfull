package com.example.demo.dao;

import com.example.demo.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Override
    Optional<Author> findById(Long aLong);

}
