package com.Trionfini.challenge.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String alias;

    // Código de seguridad
    private Long key_security;

    private Double balance;

    @OneToMany(mappedBy = "card")
    private List<Transaction> debits;

    @OneToMany(mappedBy = "card", fetch = FetchType.EAGER)
    private List<Transaction> credits;


    private Date expiration;

    public Card() {
    }

    public Card(Long id, String alias, Long key_security, Double balance, List<Transaction> debits, List<Transaction> credits, Date expiration) {
        this.id = id;
        this.alias = alias;
        this.key_security = key_security;
        this.balance = balance;
        this.debits = debits;
        this.credits = credits;
        this.expiration = expiration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Long getKey_security() {
        return key_security;
    }

    public void setKey_security(Long key_security) {
        this.key_security = key_security;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
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

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }
}
