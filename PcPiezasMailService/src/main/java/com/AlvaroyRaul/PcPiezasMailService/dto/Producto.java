package com.AlvaroyRaul.PcPiezasMailService.dto;


import lombok.Data;

import java.util.List;

@Data
public class Producto {


    private long idProducto;
    private String fabricante;
    private String nombre;
    private String descripcion;
    private String categoria;
    private float precio;


    private String imagen;


    private List<Carrito> carritos;




    private Usuario Vendedor;
    private List<Item> Item;//Puede haber muchos items en un carrito pero hasta que no se compre no se "Transforma" en producto.



    public Producto() {

    }

    public Producto(Producto producto) {
        this.idProducto = producto.getIdProducto();
        this.fabricante = producto.getFabricante();
        this.nombre = producto.getNombre();
        this.descripcion = producto.getDescripcion();
        this.categoria = producto.getCategoria();
        this.precio = producto.getPrecio();
        this.imagen = producto.getImagen();
        this.carritos = producto.getCarritos();
        Vendedor = producto.getVendedor();
        Item = producto.getItems();
    }

    @Override
    public String toString(){
        return "Producto{"+ "id="+idProducto+"nombre="+nombre+"descricion="+descripcion+"fabricant="+fabricante+"vendedor="+Vendedor+"categoria"+categoria+"precio="+precio+"imagen="+imagen +" }";

    }

    public long getStockProducto() {
        return Item.stream().filter(i -> i.getVenta() == null).count();
    }

    public List<Item> getItemsForSale() {
        return Item.stream().filter(i -> i.getVenta() == null).toList();
    }

    public List<Item> getItems() {
        return Item;
    }

    public long getIdProducto() {
        return idProducto;
    }

    public String getFabricante() {
        return fabricante;
    }

    public Usuario getVendedor() {
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

    public void setVendedor(Usuario vendedor) {
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
    public List<Carrito> getCarritos() {
        return carritos;
    }

    public void setCarritos(List<Carrito> carritos) {
        this.carritos = carritos;
    }

}
