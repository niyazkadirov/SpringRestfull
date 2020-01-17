package com.example.demo.DTO;

import com.example.demo.domain.Author;
import com.example.demo.domain.Book;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AuthorDTO {
    private Long id;
    private String fullName;
    private LocalDateTime dob;



    private List<BookDTO> bookDTOList;

    public List<AuthorDTO> getBookDTOList(List<Author> authorList) {
        List<AuthorDTO> authorDTOList = new ArrayList<>();

        for (Author author: authorList){
            bookDTOList = new ArrayList<>();
            AuthorDTO authorDTO = new AuthorDTO();

            authorDTO.setId(author.getId());
            authorDTO.setFullName(author.getFullName());
            authorDTO.setDob(author.getDob());
            for (Book book : author.getBooks()){
                BookDTO bookDTO = new BookDTO();

                bookDTO.setPublishedAt(book.getPublishedAt());
                bookDTO.setName(book.getName());
                bookDTO.setAnnotation(book.getAnnotation());
                bookDTO.setId(book.getId());

                bookDTOList.add(bookDTO);
            }
            authorDTO.setBookDTOList(bookDTOList);
            authorDTOList.add(authorDTO);
        }
        return authorDTOList;
    }





    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDateTime getDob() {
        return dob;
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
    }

    public List<BookDTO> getBookDTOList() {
        return bookDTOList;
    }

    public void setBookDTOList(List<BookDTO> bookDTOList) {
        this.bookDTOList = bookDTOList;
    }
}
