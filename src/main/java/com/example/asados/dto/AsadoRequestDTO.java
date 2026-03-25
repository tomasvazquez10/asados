package com.example.asados.dto;

import java.time.LocalDate;
import java.util.List;

public class AsadoRequestDTO {

    private LocalDate fecha;
    private Double precio;

    private Long grupoId;
    private Long sedeId;
    private Long tipoId;

    private List<Long> comensalesIds;
    private List<CorteCreateDTO> cortes;

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

    public Long getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(Long grupoId) {
        this.grupoId = grupoId;
    }

    public Long getSedeId() {
        return sedeId;
    }

    public void setSedeId(Long sedeId) {
        this.sedeId = sedeId;
    }

    public Long getTipoId() {
        return tipoId;
    }

    public void setTipoId(Long tipoId) {
        this.tipoId = tipoId;
    }

    public List<Long> getComensalesIds() {
        return comensalesIds;
    }

    public void setComensalesIds(List<Long> comensalesIds) {
        this.comensalesIds = comensalesIds;
    }

    public List<CorteCreateDTO> getCortes() {
        return cortes;
    }

    public void setCortes(List<CorteCreateDTO> cortes) {
        this.cortes = cortes;
    }
}
