package com.AlvaroyRaul.PcPiezasMailService;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class simplifiedVenta {
    class SimpleItem {
        private String nSerie;
        private String fabricante;
        private String nombre;
        private String descripcion;
        private String categoria;
        private float precio;

        public SimpleItem(String nSerie, String fabricante, String nombre, String descripcion, String categoria, float precio) {
            this.nSerie = nSerie;
            this.fabricante = fabricante;
            this.nombre = nombre;
            this.descripcion = descripcion;
            this.categoria = categoria;
            this.precio = precio;
        }

        public String getnSerie() {
            return nSerie;
        }

        public String getFabricante() {
            return fabricante;
        }

        public String getNombre() {
            return nombre;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public String getCategoria() {
            return categoria;
        }

        public float getPrecio() {
            return precio;
        }
    }
    private long idVenta;
    private String dirEnvio;
    private float total;
    private LocalDate FechaCompra;
    private List<SimpleItem> listaItems; //Cuando se procese la compra se escoge un item que corresponda a ese producto
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


    public List<SimpleItem> getListaItems() {
        return listaItems;
    }



    public simplifiedVenta() {

    }
}