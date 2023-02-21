package com.AlvaroyRaul.PcPiezas.database.entity;
import javax.persistence.*;
import java.util.List;

@Entity

public class carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;//id de carrito.
    private long cantidad;
    @OneToOne(mappedBy = "Carrito")//un carrito por venta
    private venta Venta;
    @OneToOne(mappedBy = "Carrito")//Un carrito por usuario
    private usuario Usuario;
    @OneToMany(mappedBy = "Carrito")//un carrito para varios items
    private List<item> listaItems;





}