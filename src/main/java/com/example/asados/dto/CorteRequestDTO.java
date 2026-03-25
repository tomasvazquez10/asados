package com.example.asados.dto;

public class CorteRequestDTO {

    private Double cantidad;
    private Long corteNombreId;
    private Long asadoId;

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Long getCorteNombreId() {
        return corteNombreId;
    }

    public void setCorteNombreId(Long corteNombreId) {
        this.corteNombreId = corteNombreId;
    }

    public Long getAsadoId() {
        return asadoId;
    }

    public void setAsadoId(Long asadoId) {
        this.asadoId = asadoId;
    }
}
