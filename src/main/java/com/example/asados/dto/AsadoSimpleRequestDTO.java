package com.example.asados.dto;

public class AsadoSimpleRequestDTO {
    private String fecha;
    private String comensales;
    private String cortes;
    private String tipo;
    private String sede;
    private String precio;
    private String grupo;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getComensales() {
        return comensales;
    }

    public void setComensales(String comensales) {
        this.comensales = comensales;
    }

    public String getCortes() {
        return cortes;
    }

    public void setCortes(String cortes) {
        this.cortes = cortes;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
}
