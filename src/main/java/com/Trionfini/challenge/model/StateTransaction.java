package com.Trionfini.challenge.model;

public enum StateTransaction {
    COMPLETADO("completado"),
    RECHAZADO("rechazado"),
    PENDIENTE("pendiente");

    private final String estado;

    StateTransaction(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }
}
