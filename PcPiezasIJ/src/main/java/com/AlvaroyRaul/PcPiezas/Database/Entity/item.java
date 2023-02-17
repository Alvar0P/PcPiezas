package com.AlvaroyRaul.PcPiezas.Database.Entity;

import javax.persistence.*;

@Entity
public class item {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    @OneToOne//Es una copia del producto por si se añade al carrito pero no se compra que no se elimine o se reduzca la cantidad
    private producto Producto;
    @ManyToOne//Muchos items en un carrito
    private carrito Carrito;





}
