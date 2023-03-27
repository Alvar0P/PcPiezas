package com.AlvaroyRaul.PcPiezasMailService.dto;


import lombok.Data;

@Data
public class Usuario {

    private long idUsuario;//Para todos

    private String username;//Para todos

    private String password;//Para todos

    private String email;//Para todos

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
