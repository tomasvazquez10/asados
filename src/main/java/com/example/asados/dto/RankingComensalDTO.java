package com.example.asados.dto;

public class RankingComensalDTO{

    private Integer ranking;
    private Long idComensal;
    private String comensal;
    private Integer totalAsados;
    private Double porcentaje;
    private Integer racha;
    private String movimiento;

    public RankingComensalDTO(Integer ranking, Long idComensal, String comensal, Integer totalAsados, Double porcentaje, Integer racha, String movimiento) {
        this.ranking = ranking;
        this.idComensal = idComensal;
        this.comensal = comensal;
        this.totalAsados = totalAsados;
        this.porcentaje = porcentaje;
        this.racha = racha;
        this.movimiento = movimiento;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public Long getIdComensal() {
        return idComensal;
    }

    public void setIdComensal(Long idComensal) {
        this.idComensal = idComensal;
    }

    public String getComensal() {
        return comensal;
    }

    public void setComensal(String comensal) {
        this.comensal = comensal;
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
}
