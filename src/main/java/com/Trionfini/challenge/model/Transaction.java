package com.Trionfini.challenge.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date;
    private Double amount;
    private StateTransaction state;
    private TypeTransaction type;


    @ManyToOne
    @JoinColumn(name = "client")
    @JsonIgnore
    private Client client;

    public Transaction() {
    }

    public Transaction(Long id, String description, LocalDate date, Double amount, StateTransaction state, TypeTransaction type, Client client) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.amount = amount;
        this.state = state;
        this.type = type;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public StateTransaction getState() {
        return state;
    }

    public void setState(StateTransaction state) {
        this.state = state;
    }

    public TypeTransaction getType() {
        return type;
    }

    public void setType(TypeTransaction type) {
        this.type = type;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
