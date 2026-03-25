package com.example.asados.dto;

public class CorteResponseDTO {

    private Long id;
    private Double cantidad;
    private Long corteNombreId;
    private String corteNombreDesc;
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

    public String getCorteNombreDesc() {
        return corteNombreDesc;
    }

    public void setCorteNombreDesc(String corteNombreDesc) {
        this.corteNombreDesc = corteNombreDesc;
    }

    public Long getAsadoId() {
        return asadoId;
    }

    public void setAsadoId(Long asadoId) {
        this.asadoId = asadoId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
