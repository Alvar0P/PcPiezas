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
    private String nombre;
    private String descripcion;
    private String categoria;
    private float precio;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String imagen;

    @ManyToMany(fetch = FetchType.LAZY)//Un producto puede estar en varios carritos.
    @JoinTable(name = "productosEnCarritos", joinColumns = {
            @JoinColumn(name = "producto_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "carrito_id",
                    nullable = false, updatable = false) })
    private List<carrito> carritos;

    public List<carrito> getCarritos() {
        return carritos;
    }

    public void setCarritos(List<carrito> carritos) {
        this.carritos = carritos;
    }

    @ManyToOne//Varios productos para un vendedor
    private usuario Vendedor;
    @OneToMany(mappedBy = "Producto",cascade = CascadeType.REMOVE)//copia para el item, si se borra el producto es que no hay existencias y se borra el item de los carritos.O se pone que esta agotado
    private List<item> Item;//Puede haber muchos items en un carrito pero hasta que no se compre no se "Transforma" en producto.

    /*public producto(String nombre, String descripcion,String fabricante, usuario vendedor, float precio) {

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fabricante = fabricante;
        this.Vendedor = vendedor;
        this.precio = precio;
    }

    protected producto() {

    }*/

    public producto() {

    }
    @Override
    public String toString(){
        return "Producto{"+ "id="+idProducto+"nombre="+nombre+"descricion="+descripcion+"fabricant="+fabricante+"vendedor="+Vendedor+"precio="+precio+"imagen="+imagen +" }";

    }

    public long getIdProducto() {
        return idProducto;
    }

    public String getFabricante() {
        return fabricante;
    }

    public usuario getVendedor() {
        return Vendedor;
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
    public String getImagen() {return imagen;}

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public void setVendedor(usuario vendedor) {
        this.Vendedor = vendedor;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setImagen(String imagen){
        this.imagen = imagen;
    }

}
