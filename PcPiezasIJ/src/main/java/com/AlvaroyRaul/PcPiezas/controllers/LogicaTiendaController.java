package com.AlvaroyRaul.PcPiezas.controllers;

import com.AlvaroyRaul.PcPiezas.database.entity.Item;
import com.AlvaroyRaul.PcPiezas.database.entity.Producto;
import com.AlvaroyRaul.PcPiezas.database.entity.Usuario;
import com.AlvaroyRaul.PcPiezas.database.entity.Venta;
import com.AlvaroyRaul.PcPiezas.database.repository.CarritoRepo;
import com.AlvaroyRaul.PcPiezas.database.repository.ItemRepo;
import com.AlvaroyRaul.PcPiezas.database.repository.UsuarioRepo;
import com.AlvaroyRaul.PcPiezas.servicies.ServicioCarrito;
import com.AlvaroyRaul.PcPiezas.servicies.ServicioLogicaTienda;
import com.AlvaroyRaul.PcPiezas.servicies.ServicioVenta;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

        Usuario u = new Usuario();
        u = userRepo.findById((long)2).get();//Prueba

        List<Producto> listaProductos = new ArrayList<>();
        listaProductos = u.getCarrito().getProductos();

        Random random = new Random();

        List<Item> listaItems = new ArrayList<>();

        List<Item> itemsAdquiridos = new ArrayList<>();
        for (Producto p:listaProductos) {
            
             if(p.getStockProducto() > 0) {
                 itemsAdquiridos.add(p.getItem().get(0));
             }
        }
        Venta v = new Venta();
        v = servVenta.nuevaVenta(itemsAdquiridos,u);
        servTienda.generaFactura(v);

        for (Item i:itemsAdquiridos) {
            itemRepo.deleteById(i.getnSerie());
            itemRepo.save(i);
        }
        servCarrito.deleteCarritoById(u.getCarrito().getIdCarrito());
        carritoRepo.save(u.getCarrito());
        userRepo.save(u);


        return "redirect:/inicio";
    }


    
}
