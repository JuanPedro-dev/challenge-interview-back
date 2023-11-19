package com.Trionfini.challenge.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String password;
    private Double balance;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Card> cards;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Invoice> invoices;

    @OneToMany(mappedBy = "client")
    private List<Transaction> debits;

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<Transaction> credits;


    public Client() {
    }

    public Client(Long id, String name, String password, Double balance, List<Card> cards, List<Invoice> invoices, List<Transaction> debits, List<Transaction> credits) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.balance = balance;
        this.cards = cards;
        this.invoices = invoices;
        this.debits = debits;
        this.credits = credits;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public List<Transaction> getDebits() {
        return debits;
    }

    public void setDebits(List<Transaction> debits) {
        this.debits = debits;
    }

    public List<Transaction> getCredits() {
        return credits;
    }

    public void setCredits(List<Transaction> credits) {
        this.credits = credits;
    }
}
