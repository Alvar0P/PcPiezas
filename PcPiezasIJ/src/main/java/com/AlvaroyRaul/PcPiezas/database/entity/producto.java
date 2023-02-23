package com.AlvaroyRaul.PcPiezas.database.entity;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "producto")
public class producto {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "idproducto")
    private long idProducto;
    private String fabricante;
    private String vendedor;
    private String nombre;
    private String Descripcion;
    private int valoracion;
    private String categoria;
    private float precio;
    @ManyToOne//Varios productos para un vendedor
    private usuario Vendedor;
    @OneToMany(mappedBy = "Producto",cascade = CascadeType.REMOVE)//copia para el item, si se borra el producto es que no hay existencias y se borra el item de los carritos.O se pone que esta agotado
    private List<item> Item;//Puede haber muchos items en un carrito pero hasta que no se compre no se "Transforma" en producto.

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
