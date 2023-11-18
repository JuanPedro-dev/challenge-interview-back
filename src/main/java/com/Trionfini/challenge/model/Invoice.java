package com.Trionfini.challenge.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;

@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native")
    private Long id;

    // Monto total de la factura
    private Double global;
    // Pago Mensual
    private Double parcial;
    // Cantidad de Cuotas totales
    private int fees_global;

    // Cantidad de Cuotas abonadas
    private int fees_parcial;
    // Fecha de vencimiento
    private LocalDate date_issued;
    // Tasa de interés
    private Double rate;
    // Esta abonada o no
    private Boolean isPayed;

    @ManyToOne
    @JoinColumn(name = "client")
    @JsonIgnore
    private Client client;

    public Invoice() {
    }

    public Invoice(Long id, Double global, Double parcial, int fees_global, int fees_parcial, LocalDate date_issued, Double rate, Boolean isPayed, Client client) {
        this.id = id;
        this.global = global;
        this.parcial = parcial;
        this.fees_global = fees_global;
        this.fees_parcial = fees_parcial;
        this.date_issued = date_issued;
        this.rate = rate;
        this.isPayed = isPayed;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getGlobal() {
        return global;
    }

    public void setGlobal(Double global) {
        this.global = global;
    }

    public Double getParcial() {
        return parcial;
    }

    public void setParcial(Double parcial) {
        this.parcial = parcial;
    }

    public int getFees_global() {
        return fees_global;
    }

    public void setFees_global(int fees_global) {
        this.fees_global = fees_global;
    }

    public int getFees_parcial() {
        return fees_parcial;
    }

    public void setFees_parcial(int fees_parcial) {
        this.fees_parcial = fees_parcial;
    }

    public LocalDate getDate_issued() {
        return date_issued;
    }

    public void setDate_issued(LocalDate date_issued) {
        this.date_issued = date_issued;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Boolean getIsPayed() {
        return isPayed;
    }

    public void setIsPayed(Boolean payed) {
        isPayed = payed;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
