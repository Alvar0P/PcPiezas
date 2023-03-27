package com.AlvaroyRaul.PcPiezasMailService.dto;

import lombok.Data;

import java.util.List;

@Data
public class Carrito {




    private long idCarrito;//id de carrito.
    private long cantidad;

    private List<Producto> productos;


    public Carrito() {
    }

    public long getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(long idCarrito) {
        this.idCarrito = idCarrito;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public float calcularSubtotal(){
        float subtotal =0;
        for (Producto p:productos) {
            if(p.getStockProducto() > 0) {
                subtotal += p.getPrecio();
            }
        }
        return subtotal;
    }




}