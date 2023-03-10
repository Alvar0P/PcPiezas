package com.AlvaroyRaul.PcPiezas.controllers;

import com.AlvaroyRaul.PcPiezas.database.entity.*;
import com.AlvaroyRaul.PcPiezas.database.repository.CarritoRepo;
import com.AlvaroyRaul.PcPiezas.database.repository.ItemRepo;
import com.AlvaroyRaul.PcPiezas.database.repository.UsuarioRepo;
import com.AlvaroyRaul.PcPiezas.servicies.ServicioCarrito;
import com.AlvaroyRaul.PcPiezas.servicies.ServicioLogicaTienda;
import com.AlvaroyRaul.PcPiezas.servicies.ServicioVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Controller
public class LogicaTiendaController {
    @Autowired
    private UsuarioRepo userRepo;
    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private CarritoRepo carritoRepo;
    @Autowired
    private ServicioVenta servVenta;
    @Autowired
    private ServicioLogicaTienda servTienda;
    @Autowired
    private ServicioCarrito servCarrito;

    @GetMapping("/compra")//id del carrito
    public String checkOut() throws IOException {

        Usuario u = userRepo.findById((long)2).get();//Prueba
        List<Producto> listaProductos = u.getCarrito().getProductos();
        Carrito c = u.getCarrito();


        List<Item> itemsAdquiridos = new ArrayList<>();
        for (Producto p:listaProductos) {
             if(p.getStockProducto() > 0) {
                 itemsAdquiridos.add(p.getItemsForSale().get(0));
             }
        }
        if(itemsAdquiridos.size() != 0) {
            Venta v = new Venta();
            v = servVenta.nuevaVenta(itemsAdquiridos, u);
            servTienda.generaFactura(v);
            servCarrito.deleteCarritoByIdUsuario(c.getIdCarrito());

            //userRepo.save(u);
            //carritoRepo.save(c);
        }


        return "/inicio";
    }


    
}
