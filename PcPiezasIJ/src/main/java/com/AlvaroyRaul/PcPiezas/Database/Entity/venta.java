package com.AlvaroyRaul.PcPiezas.Database.Entity;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
public class venta {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    private String dirEnvio;
    private float total;
    private LocalDate FechaCompra;
    @OneToOne
    private carrito Carrito; //Un carrito por venta. Del carrito se coge el Set que pertenezca al usuario.
    @OneToOne
    private vendedor Vendedor;//Un vendedor, si en el carrito hay productos de otros vendedores se crea otro venta y luego se une en unico pdf(por ver)
    @OneToOne
    private usuario comprador;//Un comprador
    public venta(String dirEnvio, float total, LocalDate FechaCompra,carrito Carrito,vendedor Vendedor, usuario comprador){
        this.dirEnvio = dirEnvio;
        this.total = total;
        this.FechaCompra = FechaCompra;
        this.Carrito = Carrito;
        this.Vendedor = Vendedor;
        this.comprador = comprador;

    }

    protected venta() {

    }

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public String getDirEnvio() {return dirEnvio;}

    public void setDirEnvio(String dirEnvio) {this.dirEnvio = dirEnvio;}

    public float getTotal() {return total;}

    public void setTotal(float total) {this.total = total;}

    public LocalDate getFechaCompra() {return FechaCompra;}

    public void setFechaCompra(LocalDate fechaCompra) {FechaCompra = fechaCompra;}

    public carrito getCarrito() {return Carrito;}

    public void setCarrito(carrito carrito) {Carrito = carrito;}

    public vendedor getVendedor() {return Vendedor;}

    public void setVendedor(vendedor vendedor) {Vendedor = vendedor;}

    public usuario getComprador() {return comprador;}

    public void setComprador(usuario comprador) {this.comprador = comprador;}




}
