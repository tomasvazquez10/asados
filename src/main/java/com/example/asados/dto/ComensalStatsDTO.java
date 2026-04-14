package com.example.asados.dto;

public class ComensalStatsDTO {

    private String nombre;
    private Long cantidadAsados;
    private Double porcentaje;
    private Double cantidadKilos;

    public ComensalStatsDTO(String nombre, Long cantidadAsados, Double porcentaje, Double cantidadKilos) {
        this.nombre = nombre;
        this.cantidadAsados = cantidadAsados;
        this.porcentaje = porcentaje;
        this.cantidadKilos = cantidadKilos;
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

    public Double getCantidadKilos() {
        return cantidadKilos;
    }

    public void setCantidadKilos(Double cantidadKilos) {
        this.cantidadKilos = cantidadKilos;
    }
}
