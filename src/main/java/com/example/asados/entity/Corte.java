package com.example.asados.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
public class Corte {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double cantidad;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cortenombre_id", nullable = false)
    private CorteNombre corteNombre;

    @ManyToOne(optional = false)
    @JoinColumn(name = "asado_id", nullable = false)
    private Asado asado;

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public CorteNombre getCorteNombre() {
        return corteNombre;
    }

    public void setCorteNombre(CorteNombre corteNombre) {
        this.corteNombre = corteNombre;
    }

    public Asado getAsado() {
        return asado;
    }

    public void setAsado(Asado asado) {
        this.asado = asado;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}