package com.example.asados.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(
        name = "ranking_mensual",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {
                                "comensal_id",
                                "anio",
                                "mes"
                        }
                )
        }
)
public class RankingMensual {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer anio;

    private Integer mes;

    private Integer ranking;

    private Integer totalAsados;

    private Double porcentaje;

    private Integer racha;

    private String movimiento;

    private Integer variacionRanking;

    @ManyToOne
    @JoinColumn(name = "comensal_id")
    private Comensal comensal;


    public RankingMensual() {
    }

    // getters y setters

    public Integer getVariacionRanking() {
        return variacionRanking;
    }

    public void setVariacionRanking(
            Integer variacionRanking) {

        this.variacionRanking =
                variacionRanking;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public Integer getTotalAsados() {
        return totalAsados;
    }

    public void setTotalAsados(Integer totalAsados) {
        this.totalAsados = totalAsados;
    }

    public Double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Integer getRacha() {
        return racha;
    }

    public void setRacha(Integer racha) {
        this.racha = racha;
    }

    public String getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(String movimiento) {
        this.movimiento = movimiento;
    }

    public Comensal getComensal() {
        return comensal;
    }

    public void setComensal(Comensal comensal) {
        this.comensal = comensal;
    }
}