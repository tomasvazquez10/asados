package com.example.asados.dto;

public class CorteCreateDTO {
    private Long corteNombreId;
    private Double cantidad;

    public Long getCorteNombreId() {
        return corteNombreId;
    }

    public void setCorteNombreId(Long corteNombreId) {
        this.corteNombreId = corteNombreId;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }
}
