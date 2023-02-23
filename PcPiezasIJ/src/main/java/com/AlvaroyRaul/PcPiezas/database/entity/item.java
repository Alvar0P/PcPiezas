package com.AlvaroyRaul.PcPiezas.database.entity;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class item {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long idItem;

    @ManyToOne//Es una copia del producto que representa la unidad que tenemos en el almacen
    @JoinColumn(name="idProducto",nullable = false)
    private producto Producto;

    private long ventaId; //Relacion uni-direccional entre venta e item





}
