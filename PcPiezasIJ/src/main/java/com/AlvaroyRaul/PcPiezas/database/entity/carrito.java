package com.AlvaroyRaul.PcPiezas.database.entity;
import javax.persistence.*;
import java.util.List;

@Entity

@Table(name = "carrito", uniqueConstraints = { @UniqueConstraint(columnNames = { "IdUsuario", "IdProducto" }) }) //Reestriccion que permite una unica fila con cierta combinacion de producto y usuario
public class carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long idCarrito;//id de carrito.
    private long cantidad;
    @ManyToOne(fetch = FetchType.LAZY)//Un usuario tiene varias entradas en la tabla carrito
    @JoinColumn(name = "IdUsuario",  referencedColumnName="IdUsuario") //Un usuario tiene varias entradas en la tabla carrito
    private usuario Usuario;

    @ManyToOne(fetch = FetchType.LAZY) //Un producto tambien puede tener varias entradas
    @JoinColumn(name="idproducto", nullable = true)
    private producto idProducto;


    protected carrito() {
    }
}