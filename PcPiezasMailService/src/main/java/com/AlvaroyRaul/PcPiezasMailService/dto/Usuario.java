package com.AlvaroyRaul.PcPiezasMailService.dto;


import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Usuario implements Serializable {


    private long idUsuario;//Para todos

    private String username;//Para todos

    private String password;//Para todos

    private String rol;

    private String email;//Para todos
    private String direccion;//usuario y vendedor
    private long tlf;//usuario y vendedor
    private boolean VIP;//Solo usuario
    private long tarjeta;//Solo usuario
    private String cuentaBancaria;//Solo vendedor
    private List<Producto> productos;//Solo vendedor

    private Carrito carrito;
    private String venta;

    public String getVenta() {
        return venta;
    }

    public void setVenta(String venta) {
        this.venta = venta;
    }


    public long getIdUsuario() {
        return idUsuario;
    }


    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setUsername(String username) {
        this.username = username;
    }//Para todos
    public String getUsername() {
        return username;
    }//Para todos
    public void setEmail(String email) {
        this.email = email;
    }//Para todos
    public String getEmail() {
        return email;
    }//Para todos
    public void setPassword(String password) {
        this.password = password;
    }//Para todos
    public String getPassword(){return password;}//Para todos(Para el futuro si se necesita,si no se borra)









}
