package com.example.asados.dto;

import java.util.Map;

public class AsadoMesResumenDTO {

    private int cantidadAsados;
    private int cantidadComensales;
    private double kilosTotales;
    private Map<String, Long> cantidadPorTipoAsado;
    private double precioPromedio;

    public int getCantidadAsados() {
        return cantidadAsados;
    }

    public void setCantidadAsados(int cantidadAsados) {
        this.cantidadAsados = cantidadAsados;
    }

    public int getCantidadComensales() {
        return cantidadComensales;
    }

    public void setCantidadComensales(int cantidadComensales) {
        this.cantidadComensales = cantidadComensales;
    }

    public double getKilosTotales() {
        return kilosTotales;
    }

    public void setKilosTotales(double kilosTotales) {
        this.kilosTotales = kilosTotales;
    }

    public Map<String, Long> getCantidadPorTipoAsado() {
        return cantidadPorTipoAsado;
    }

    public void setCantidadPorTipoAsado(Map<String, Long> cantidadPorTipoAsado) {
        this.cantidadPorTipoAsado = cantidadPorTipoAsado;
    }

    public double getPrecioPromedio() {
        return precioPromedio;
    }

    public void setPrecioPromedio(double precioPromedio) {
        this.precioPromedio = precioPromedio;
    }
}
