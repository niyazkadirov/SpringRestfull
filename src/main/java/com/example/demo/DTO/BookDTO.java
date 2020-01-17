package com.example.demo.DTO;

import com.example.demo.domain.Author;
import com.example.demo.domain.Book;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BookDTO {

    private Long id;
    private String name;
    private LocalDateTime publishedAt;
    private String annotation;

    private List<AuthorDTO> authorDTOList;

    public List<BookDTO> getBookDTOList(List<Book> bookList) {
        List<BookDTO> bookDTOList = new ArrayList<>();

        for (Book book: bookList){
            authorDTOList = new ArrayList<>();
            BookDTO bookDTO = new BookDTO();

            bookDTO.setId(book.getId());
            bookDTO.setAnnotation(book.getAnnotation());
            bookDTO.setName(book.getName());
            bookDTO.setPublishedAt(book.getPublishedAt());
            for (Author author : book.getAuthors()){
                AuthorDTO authorDTO = new AuthorDTO();

                authorDTO.setDob(author.getDob());
                authorDTO.setFullName(author.getFullName());
                authorDTO.setId(author.getId());
                authorDTOList.add(authorDTO);
            }
            bookDTO.setAuthorDTOList(authorDTOList);
            bookDTOList.add(bookDTO);
        }
        return bookDTOList;
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

    public List<AuthorDTO> getAuthorDTOList() {
        return authorDTOList;
    }

    public void setAuthorDTOList(List<AuthorDTO> authorDTOList) {
        this.authorDTOList = authorDTOList;
    }
}
