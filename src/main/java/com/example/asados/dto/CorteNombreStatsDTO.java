package com.example.asados.dto;

public class CorteNombreStatsDTO {

    private String nombre;
    private Double totalKilos;
    private Long cantidadUsos;

    public CorteNombreStatsDTO(String nombre, Double totalKilos, Long cantidadUsos) {
        this.nombre = nombre;
        this.totalKilos = totalKilos;
        this.cantidadUsos = cantidadUsos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getTotalKilos() {
        return totalKilos;
    }

    public void setTotalKilos(Double totalKilos) {
        this.totalKilos = totalKilos;
    }

    public Long getCantidadUsos() {
        return cantidadUsos;
    }

    public void setCantidadUsos(Long cantidadUsos) {
        this.cantidadUsos = cantidadUsos;
    }
}
