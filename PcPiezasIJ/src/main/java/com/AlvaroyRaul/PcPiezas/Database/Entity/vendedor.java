package com.AlvaroyRaul.PcPiezas.Database.Entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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
    @OneToMany(mappedBy = "Vendedor", cascade = CascadeType.REMOVE)// Si borra el vendedor se borran sus productos a la venta
    private List<producto> productos;
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

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}

    public String getUsername() {return username;}

    public void setUsername(String username) {this.username = username;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public long getCuentaBancaria() {return cuentaBancaria;}

    public void setCuentaBancaria(long cuentaBancaria) {this.cuentaBancaria = cuentaBancaria;}

    public String getDireccion() {return direccion;}

    public void setDireccion(String direccion) {this.direccion = direccion;}

    public List<producto> getProductos() {return productos;}

    public void setProductos(List<producto> productos) {this.productos = productos;}

    public long getTlf() {return tlf;}

    public void setTlf(long tlf) {this.tlf = tlf;}

    public LocalDate getFechaCreacion() {return FechaCreacion;}

    public void setFechaCreacion(LocalDate fechaCreacion) {FechaCreacion = fechaCreacion;}

}
