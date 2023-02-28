package com.AlvaroyRaul.PcPiezas.database.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "venta")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long idVenta;
    private String dirEnvio;
    private float total;
    private LocalDate FechaCompra;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "ventaId", nullable = true)
    private List<Item> listaItems; //Cuando se procese la compra se escoge un item que corresponda a ese producto
    @OneToOne
    private Usuario comprador;//Un comprador
    public Venta(String dirEnvio, float total, LocalDate FechaCompra, Carrito Carrito, Usuario Vendedor, Usuario comprador){
        this.dirEnvio = dirEnvio;
        this.total = total;
        this.FechaCompra = FechaCompra;
        this.comprador = comprador;

    }

    protected Venta() {

    }

    public long getId() {return idVenta;}

    public void setId(long id) {this.idVenta = id;}

    public String getDirEnvio() {return dirEnvio;}

    public void setDirEnvio(String dirEnvio) {this.dirEnvio = dirEnvio;}

    public float getTotal() {return total;}

    public void setTotal(float total) {this.total = total;}

    public LocalDate getFechaCompra() {return FechaCompra;}

    public void setFechaCompra(LocalDate fechaCompra) {FechaCompra = fechaCompra;}


    public Usuario getComprador() {return comprador;}

    public void setComprador(Usuario comprador) {this.comprador = comprador;}




}
