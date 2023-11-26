package com.example.redeamerica.model;

public enum ERequestStatus {
    PENDIENTE(1),
    APROBADO(2),
    RECHAZADO(3);

    private final int value;

    ERequestStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

