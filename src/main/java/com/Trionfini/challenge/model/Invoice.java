package com.Trionfini.challenge.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

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
    private Date date_issued;
    // Tasa de interés
    private Double rate;
    // Esta abonada o no
    private Boolean isPayed;

    public Invoice() {
    }

    public Invoice(Long id, Double global, Double parcial, int fees_global, int fees_parcial, Date date_issued, Double rate, Boolean isPayed) {
        this.id = id;
        this.global = global;
        this.parcial = parcial;
        this.fees_global = fees_global;
        this.fees_parcial = fees_parcial;
        this.date_issued = date_issued;
        this.rate = rate;
        this.isPayed = isPayed;
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

    public Date getDate_issued() {
        return date_issued;
    }

    public void setDate_issued(Date date_issued) {
        this.date_issued = date_issued;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Boolean getisPayed() {
        return isPayed;
    }

    public void setisPayed(Boolean payed) {
        isPayed = payed;
    }
}
