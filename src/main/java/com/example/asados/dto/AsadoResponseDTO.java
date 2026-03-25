package com.example.asados.dto;

import java.time.LocalDate;
import java.util.List;

public class AsadoResponseDTO {

    private Long id;
    private LocalDate fecha;
    private Double precio;

    private String grupoNombre;
    private String sedeNombre;
    private String tipoNombre;

    private List<String> comensales;

    private List<CorteDTO> cortes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getGrupoNombre() {
        return grupoNombre;
    }

    public void setGrupoNombre(String grupoNombre) {
        this.grupoNombre = grupoNombre;
    }

    public String getSedeNombre() {
        return sedeNombre;
    }

    public void setSedeNombre(String sedeNombre) {
        this.sedeNombre = sedeNombre;
    }

    public String getTipoNombre() {
        return tipoNombre;
    }

    public void setTipoNombre(String tipoNombre) {
        this.tipoNombre = tipoNombre;
    }

    public List<String> getComensales() {
        return comensales;
    }

    public void setComensales(List<String> comensales) {
        this.comensales = comensales;
    }

    public List<CorteDTO> getCortes() {
        return cortes;
    }

    public void setCortes(List<CorteDTO> cortes) {
        this.cortes = cortes;
    }
}
