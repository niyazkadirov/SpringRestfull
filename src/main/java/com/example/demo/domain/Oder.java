package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Set;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class Oder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "flag_execution")
    private Boolean flagExecution;

    @Column(name = "flag_execution_date")
    private LocalDateTime flagExecutionDate;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "oder")
    private Set<Client> clients;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "oder")
    private Set<Book> books;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private LocalDateTime convertToUtc(LocalDateTime time) {
        return time.atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneOffset.MIN).toLocalDateTime();
    }

    public LocalDateTime getCreatedAt() {
        return convertToUtc(createdAt);
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = convertToUtc(createdAt);

    }


    public Boolean getFlagExecution() {
        return flagExecution;
    }

    public void setFlagExecution(Boolean flagExecution) {
        this.flagExecution = flagExecution;
    }

    public LocalDateTime getFlagExecutionDate() {
        return convertToUtc(flagExecutionDate);
    }

    public void setFlagExecutionDate(LocalDateTime flagExecutionDate) {
        this.flagExecutionDate = convertToUtc(flagExecutionDate);
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
