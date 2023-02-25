package com.AlvaroyRaul.PcPiezas.database.entity;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class item {
    @Id
    private String nSerie;

    @ManyToOne//Es una copia del producto que representa la unidad que tenemos en el almacen
    @JoinColumn(name="idProducto",nullable = false)
    private producto Producto;

    private long ventaId; //Relacion uni-direccional entre venta e item





}
