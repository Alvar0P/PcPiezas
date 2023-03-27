package com.AlvaroyRaul.PcPiezas.kafka.entity;

public class simplifiedItem {
    private String nSerie;
    private String fabricante;
    private String nombre;
    private String descripcion;
    private String categoria;
    private float precio;

    public simplifiedItem(String nSerie, String fabricante, String nombre, String descripcion, String categoria, float precio) {
        this.nSerie = nSerie;
        this.fabricante = fabricante;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.precio = precio;
    }

    public String getnSerie() {
        return nSerie;
    }

    public String getFabricante() {
        return fabricante;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public float getPrecio() {
        return precio;
    }
}
