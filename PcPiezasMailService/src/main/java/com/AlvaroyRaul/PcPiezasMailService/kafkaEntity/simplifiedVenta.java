package com.AlvaroyRaul.PcPiezasMailService.kafkaEntity;

import java.time.LocalDate;
import java.util.List;

public class simplifiedVenta {
    private long idVenta;
    private String dirEnvio;
    private float total;
    private LocalDate FechaCompra;
    private List<simplifiedItem> listaItems; //Cuando se procese la compra se escoge un item que corresponda a ese producto
    private String comprador;

    public long getIdVenta() {
        return idVenta;
    }

    public String getDirEnvio() {
        return dirEnvio;
    }

    public float getTotal() {
        return total;
    }


    public List<simplifiedItem> getListaItems() {
        return listaItems;
    }



    public simplifiedVenta(long idVenta, String dirEnvio, float total, LocalDate fechaCompra, List<simplifiedItem> listaItems, String comprador) {
        this.idVenta = idVenta;
        this.dirEnvio = dirEnvio;
        this.total = total;
        FechaCompra = fechaCompra;
        this.listaItems = listaItems;

        this.comprador = comprador;
    }
}