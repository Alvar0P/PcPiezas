package com.AlvaroyRaul.PcPiezas.Database.Entity;
import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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