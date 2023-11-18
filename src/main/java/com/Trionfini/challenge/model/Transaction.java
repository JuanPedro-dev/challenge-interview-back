package com.Trionfini.challenge.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "card")
    @JsonIgnore
    private Card card;

    public Transaction() {
    }

    public Transaction(Long id, Date date, Double amount) {
        this.id = id;
        this.date = date;
        this.amount = amount;
    }

    public Transaction(Long id, Date date, Double amount, Card card) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.card = card;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }


    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
