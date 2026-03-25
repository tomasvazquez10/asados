package com.example.asados.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Asado {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;
    private Double precio;

    @ManyToOne
    private Grupo grupo;

    @ManyToOne
    private Sede sede;

    @ManyToOne
    private TipoAsado tipo;

    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "asado_comensal",
            joinColumns = @JoinColumn(name = "asado_id"),
            inverseJoinColumns = @JoinColumn(name = "comensal_id")
    )
    private List<Comensal> comensales;

    @OneToMany(mappedBy = "asado", cascade = CascadeType.ALL)
    private List<Corte> cortes;

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

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public TipoAsado getTipo() {
        return tipo;
    }

    public void setTipo(TipoAsado tipo) {
        this.tipo = tipo;
    }

    public List<Comensal> getComensales() {
        return comensales;
    }

    public void setComensales(List<Comensal> comensales) {
        this.comensales = comensales;
    }

    public List<Corte> getCortes() {
        return cortes;
    }

    public void setCortes(List<Corte> cortes) {
        this.cortes = cortes;
    }
}