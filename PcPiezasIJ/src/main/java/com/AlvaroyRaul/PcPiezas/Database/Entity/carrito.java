package com.AlvaroyRaul.PcPiezas.Database.Entity;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity

public class carrito {
    @Id
    @OneToMany(mappedBy = "carrito")
    private Set<producto> listaProductos = new HashSet<>();

    @Id
    @OneToMany(mappedBy = "carrito")
    private Set<usuario> listaUsuarios = new HashSet<>();

    private long cantidad;


}