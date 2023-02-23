package com.AlvaroyRaul.PcPiezas.database.entity;
import javax.persistence.*;
import java.util.List;

@Entity

//@Table(name = "carrito", uniqueConstraints = { @UniqueConstraint(columnNames = { "IdUsuario", "IdProducto" }) }) //Reestriccion que permite una unica fila con cierta combinacion de producto y usuario
public class carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long idCarrito;//id de carrito.
    private long cantidad;
    @ManyToOne(fetch = FetchType.LAZY)//Un usuario tiene varias entradas en la tabla carrito
    @JoinColumn(name = "IdUsuario",  referencedColumnName="IdUsuario") //Un usuario tiene varias entradas en la tabla carrito
    private usuario Usuario;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) //un carrito tiene una lista de productos, cuando se procese la compra estos pasan a ser items, usamos join table para poder estableceer el nombre del la columna
    @JoinColumn(name="idproducto")
    private List<producto> listaProductos;


    protected carrito() {
    }
}