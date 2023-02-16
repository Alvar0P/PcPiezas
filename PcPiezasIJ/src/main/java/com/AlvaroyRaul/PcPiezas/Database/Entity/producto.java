package com.AlvaroyRaul.PcPiezas.Database.Entity;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class producto {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    private String fabricante;
    private String distribuidor;
    private String nombre;
    private String Descripcion;
    private int valoracion;
    private String categoria;
    private float precio;

    public producto(String fabricante, String distribuidor, String nombre, String descripcion, int valoracion, float precio) {
        this.fabricante = fabricante;
        this.distribuidor = distribuidor;
        this.nombre = nombre;
        Descripcion = descripcion;
        this.valoracion = valoracion;
        this.precio = precio;
    }

    protected producto() {

    }

    public String getFabricante() {
        return fabricante;
    }

    public String getDistribuidor() {
        return distribuidor;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public int getValoracion() {
        return valoracion;
    }

    public String getCategoria() {
        return categoria;
    }

    public float getPrecio() {
        return precio;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public void setDistribuidor(String distribuidor) {
        this.distribuidor = distribuidor;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @ManyToOne
    @JoinColumn(name = "carrito_Id")
    private carrito carrito;
}
