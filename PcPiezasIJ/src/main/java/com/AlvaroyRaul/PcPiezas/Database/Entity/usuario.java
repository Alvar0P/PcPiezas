package com.AlvaroyRaul.PcPiezas.Database.Entity;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    private String username;
    private String email;
    private String password;
    private LocalDate FechaCreacion;

    public usuario(String username, String email, String password) {
        this.id = 34;
        this.username = username;
        this.email = email;
        this.password = password;
        FechaCreacion = LocalDate.now();
    }

    protected usuario() {

    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getFechaCreacion() {
        return FechaCreacion;
    }
<<<<<<< Updated upstream
=======

    public boolean isVIP() {return VIP;}

    public long getTarjeta() {return tarjeta;}

    public String getDireccion() {return direccion;}

    public long getTlf() {return tlf;}

    @ManyToOne
    @JoinColumn(name = "carrito_Id")
    private carrito carrito;

>>>>>>> Stashed changes
}