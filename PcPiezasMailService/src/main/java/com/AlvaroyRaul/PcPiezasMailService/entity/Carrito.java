package com.AlvaroyRaul.PcPiezasMailService.entity;
import java.util.List;
public class Carrito {




    private long idCarrito;//id de carrito.
    private long cantidad;
    //@ManyToOne(fetch = FetchType.LAZY)//Un usuario tiene varias entradas en la tabla carrito
    //@JoinColumn(name = "IdUsuario",  referencedColumnName="IdUsuario") //Un usuario tiene varias entradas en la tabla carrito
    //@OneToOne(orphanRemoval = true)
    //private Usuario Usuario;


    //@ManyToOne(fetch = FetchType.LAZY) //Un producto tambien puede tener varias entradas
    //@JoinColumn(name="idproducto", nullable = true)
    //private producto idProducto;

    private List<Producto> productos;


    public Carrito() {
    }

    public long getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(long idCarrito) {
        this.idCarrito = idCarrito;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }
    /*
        public Usuario getUsuario() {
            return Usuario;
        }

        public void setUsuario(Usuario usuario) {
            Usuario = usuario;
        }

        public producto getIdProducto() {
            return idProducto;
        }

        public void setIdProducto(producto idProducto) {
            this.idProducto = idProducto;
        }
    */
    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public float calcularSubtotal(){
        float subtotal =0;
        for (Producto p:productos) {
            if(p.getStockProducto() > 0) {
                subtotal += p.getPrecio();
            }
        }
        return subtotal;
    }




}