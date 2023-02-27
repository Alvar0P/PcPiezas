package com.AlvaroyRaul.PcPiezas.database.entity;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class item {
    @Id
    private String nSerie;

    @ManyToOne//Es una copia del producto que representa la unidad que tenemos en el almacen
    @JoinColumn(name="idproducto", referencedColumnName = "idproducto", nullable = false)
    private producto Producto;
    //@Column(nullable = true)
    //private long ventaId; //Relacion uni-direccional entre venta e item

    public item(String nSerie, producto producto) {
        this.nSerie = nSerie;
        Producto = producto;
    }

    protected item() {

    }


    public String getnSerie() {
        return nSerie;
    }

    public producto getProducto() {
        return Producto;
    }
}
