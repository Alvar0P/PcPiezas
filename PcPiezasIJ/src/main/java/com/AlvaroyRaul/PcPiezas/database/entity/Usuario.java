package com.AlvaroyRaul.PcPiezas.database.entity;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long idUsuario;//Para todos
    @Column(unique = true)
    @NotNull
    private String username;//Para todos
    @NotNull
    private String password;//Para todos
    @NotNull
    private Rol rol;
    @Column(unique = true)
    @NotNull
    private String email;//Para todos
    private String direccion;//usuario y vendedor
    private long tlf;//usuario y vendedor
    private boolean VIP;//Solo usuario
    private long tarjeta;//Solo usuario
    private long cuentaBancaria;//Solo vendedor

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles;

    @OneToMany(mappedBy = "Vendedor", cascade = CascadeType.REMOVE)// Si borra el vendedor se borran sus productos a la venta
    private List<Producto> productos;//Solo vendedor
    //@OneToMany(mappedBy = "Usuario", cascade = CascadeType.ALL, orphanRemoval = true) //Productos en la tabla carrito asociados al usuario
    //private List<carrito> articulosCarrito;




    //@OneToMany(mappedBy = "Usuario", cascade = CascadeType.REMOVE)//Si se borra el usuario se borra el carrito
    //private List<carrito> Carrito;
    @OneToOne(cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)//Si se borra el usuario se borra el carrito
    private Carrito carrito;
    /*
    public usuario(String username,String email ,String password, rol Rol) {
        this.rol = Rol;
        this.username = username;
        this.email = email;
        this.password = password;

    }



    protected usuario() {

    }*/
    public Usuario() {

    }
    public void anadirUser(String username,String email ,String password, Rol Rol){

        setRol(Rol);
        setEmail(email);
        setPassword(password);
        setUsername(username);


    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
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
    public void setProductos(List<Producto> productos) {this.productos = productos;}//Solo vendedor
    public String getUsername() {
        return username;
    }//Para todos
    public String getEmail() {
        return email;
    }//Para todos
    public String getPassword(){return password;}//Para todos(Para el futuro si se necesita,si no se borra)
    public String getDireccion() {return direccion;}//Vendedor y usuario
    public long getTlf() {return tlf;}//Vendedor y usuario
    public boolean isVIP() {return VIP;}//Solo usuario
    public long getTarjeta() {return tarjeta;}//Solo usuario
    public long getCuentaBancaria() {return cuentaBancaria;}//Solo vendedor
    public List<Producto> getProductos() {return productos;}//Solo vendedor

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }


    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }






}
