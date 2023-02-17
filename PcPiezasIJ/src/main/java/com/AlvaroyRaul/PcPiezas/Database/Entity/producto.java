package com.AlvaroyRaul.PcPiezas.Database.Entity;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class producto {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    private String fabricante;
    private String vendedor;
    private String nombre;
    private String Descripcion;
    private int valoracion;
    private String categoria;
    private float precio;
    @ManyToOne//Varios productos para un vendedor
    private vendedor Vendedor;
    @OneToOne(mappedBy = "Producto",cascade = CascadeType.REMOVE)//copia para el item, si se borra el producto es que no hay existencias y se borra el item de los carritos.O se pone que esta agotado(por ver)
    private item Item;

    public producto(String fabricante, String vendedor, String nombre, String descripcion, int valoracion, float precio) {
        this.fabricante = fabricante;
        this.vendedor = vendedor;
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

    public String getvendedor() {
        return vendedor;
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

    public void setvendedor(String vendedor) {
        this.vendedor = vendedor;
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
}
