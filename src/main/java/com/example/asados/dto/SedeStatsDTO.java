package com.example.asados.dto;

public class SedeStatsDTO {

    private String nombre;
    private Long cantidadAsados;

    public SedeStatsDTO(String nombre, Long cantidadAsados) {
        this.nombre = nombre;
        this.cantidadAsados = cantidadAsados;
    }

    public String getNombre() {
        return nombre;
    }

    public Long getCantidadAsados() {
        return cantidadAsados;
    }
}
