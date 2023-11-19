package com.Trionfini.challenge.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
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

    @ManyToOne
    @JoinColumn(name = "client")
    @JsonIgnore
    private Client client;

    private LocalDate expiration;

    public Card() {
    }

    public Card(Long id, String alias, Long key_security, Double balance, Client client, LocalDate expiration) {
        this.id = id;
        this.alias = alias;
        this.key_security = key_security;
        this.balance = balance;
        this.client = client;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDate getExpiration() {
        return expiration;
    }

    public void setExpiration(LocalDate expiration) {
        this.expiration = expiration;
    }
}
