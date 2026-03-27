package com.example.asados.dto;

public class ComensalStatsDTO {

    private String nombre;
    private Long cantidadAsados;
    private Double porcentaje;

    public ComensalStatsDTO(String nombre, Long cantidadAsados, Double porcentaje) {
        this.nombre = nombre;
        this.cantidadAsados = cantidadAsados;
        this.porcentaje = porcentaje;
    }

    public String getNombre() {
        return nombre;
    }

    public Long getCantidadAsados() {
        return cantidadAsados;
    }

    public Double getPorcentaje() {
        return porcentaje;
    }
}
