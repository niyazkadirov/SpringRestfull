package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "published_at")
    private LocalDateTime publishedAt;

    @Column(name = "annotation")
    private String annotation;

    @ManyToMany(mappedBy = "books")
//    @JsonManagedReference
    private List<Author> authors;

    public Book() {
    }

    public Book(String name, String annotation) {
        this.name = name;
        this.annotation = annotation;
//        this.books = Stream.of(books).collect(Collectors.toSet());
//        this.books.forEach(x ->x.getAuthors().add(this));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(LocalDateTime publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
