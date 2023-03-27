package com.AlvaroyRaul.PcPiezasMailService.entity;


public class Item {
    private String nSerie;
    private Producto Producto;
    private Venta venta; //Relacion uni-direccional entre venta e item

    public Item(String nSerie,Producto producto) {
        this.nSerie = nSerie;
        Producto = producto;
    }

    protected Item() {

    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public String getnSerie() {
        return nSerie;
    }

    public Producto getProducto() {
        return Producto;
    }
}
