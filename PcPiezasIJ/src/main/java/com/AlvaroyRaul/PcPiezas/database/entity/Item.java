package com.AlvaroyRaul.PcPiezas.database.entity;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class Item {
    @Id
    private String nSerie;

    @ManyToOne//Es una copia del producto que representa la unidad que tenemos en el almacen
    @JoinColumn(name="idproducto", referencedColumnName = "idproducto", nullable = false)
    private com.AlvaroyRaul.PcPiezas.database.entity.Producto Producto;
    //@Column(nullable = true)
    //private long ventaId; //Relacion uni-direccional entre venta e item

    public Item(String nSerie, com.AlvaroyRaul.PcPiezas.database.entity.Producto producto) {
        this.nSerie = nSerie;
        Producto = producto;
    }

    protected Item() {

    }


    public String getnSerie() {
        return nSerie;
    }

    public com.AlvaroyRaul.PcPiezas.database.entity.Producto getProducto() {
        return Producto;
    }
}
