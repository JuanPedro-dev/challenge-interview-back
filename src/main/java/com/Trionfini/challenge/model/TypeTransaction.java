package com.Trionfini.challenge.model;

public enum TypeTransaction {
    DEBITO("debito"),
    CREDITO("credito");

    private final String tipo;

    TypeTransaction(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
