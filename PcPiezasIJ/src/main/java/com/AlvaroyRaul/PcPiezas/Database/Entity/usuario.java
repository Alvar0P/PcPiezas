package com.AlvaroyRaul.PcPiezas.Database.Entity;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;//Para todos
    @Column(unique = true)
    @NotNull
    private String username;//Para todos
    @NotNull
    private String password;//Para todos
    @Column(unique = true)
    @NotNull
    private String email;//Para todos
    private String direccion;//usuario y vendedor
    private long tlf;//usuario y vendedor
    private boolean VIP;//Solo usuario
    private long tarjeta;//Solo usuario
    private long cuentaBancaria;//Solo vendedor
    @OneToMany(mappedBy = "Vendedor", cascade = CascadeType.REMOVE)// Si borra el vendedor se borran sus productos a la venta
    private List<producto> productos;//Solo vendedor

    //@ManyToOne
    @OneToOne(cascade = CascadeType.REMOVE)//Si se borra el usuario se borra el carrito
    private carrito Carrito;

    public usuario(String username,String email ,String password) {

        this.username = username;
        this.email = email;
        this.password = password;

    }

    protected usuario() {

    }

    public void setUsername(String username) {
        this.username = username;
    }//Para todos
    public void setEmail(String email) {
        this.email = email;
    }//Para todos
    public void setPassword(String password) {
        this.password = password;
    }//Para todos
    public void setDireccion(String direccion) {this.direccion = direccion;}//Vendedor y usuario
    public void setTlf(long tlf) {this.tlf = tlf;}//Vendedor y usuario
    public void setVIP(boolean VIP) {this.VIP = VIP;}//Solo usuario
    public void setTarjeta(long tarjeta) {this.tarjeta = tarjeta;}//Solo usuario
    public void setCuentaBancaria(long cuentaBancaria) {this.cuentaBancaria = cuentaBancaria;}//Solo vendedor
    public void setProductos(List<producto> productos) {this.productos = productos;}//Solo vendedor
    public String getUsername() {
        return username;
    }//Para todos
    public long getId(){return id;}//Todos
    public String getEmail() {
        return email;
    }//Para todos
    public String getPassword(){return password;}//Para todos(Para el futuro si se necesita,si no se borra)
    public String getDireccion() {return direccion;}//Vendedor y usuario
    public long getTlf() {return tlf;}//Vendedor y usuario
    public boolean isVIP() {return VIP;}//Solo usuario
    public long getTarjeta() {return tarjeta;}//Solo usuario
    public long getCuentaBancaria() {return cuentaBancaria;}//Solo vendedor
    public List<producto> getProductos() {return productos;}//Solo vendedor









}
