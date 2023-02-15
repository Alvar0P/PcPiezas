package com.AlvaroyRaul.PcPiezas.Database.Entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;

@Entity
public class vendedor {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    private String username;
    private String email;
    private String password;
    private long cuentaBancaria;
    private String direccion;//por si hay que devolver productos defectuosos
    private long tlf;
    private LocalDate FechaCreacion;

    public vendedor(String username, String email, String password,long cuentaBancaria,String direccion,long tlf) {
        this.id = 34;
        this.username = username;
        this.email = email;
        this.password = password;
        this.cuentaBancaria = cuentaBancaria;
        this.direccion = direccion;
        this.tlf = tlf;
        FechaCreacion = LocalDate.now();
    }

    protected vendedor() {

    }
}
