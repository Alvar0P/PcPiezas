package com.AlvaroyRaul.PcPiezas.controllers;

import com.AlvaroyRaul.PcPiezas.database.entity.*;
import com.AlvaroyRaul.PcPiezas.database.repository.CarritoRepo;
import com.AlvaroyRaul.PcPiezas.database.repository.ItemRepo;
import com.AlvaroyRaul.PcPiezas.database.repository.UsuarioRepo;
import com.AlvaroyRaul.PcPiezas.publisher.RabbitMQProducer;
import com.AlvaroyRaul.PcPiezas.servicies.ServicioCarrito;
import com.AlvaroyRaul.PcPiezas.servicies.ServicioLogicaTienda;
import com.AlvaroyRaul.PcPiezas.servicies.ServicioVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/user")
public class LogicaTiendaController {

    private RabbitMQProducer producer;

    public LogicaTiendaController(RabbitMQProducer producer) {
        this.producer = producer;
    }

    @Autowired
    private UsuarioRepo userRepo;

    @Autowired
    private ServicioVenta servVenta;
    @Autowired
    private ServicioLogicaTienda servTienda;
    @Autowired
    private ServicioCarrito servCarrito;

    @GetMapping("/compra")//id del carrito
    public String checkOut(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Usuario u = userRepo.findByUsername(request.getUserPrincipal().getName());


        if(u.getTarjeta() == 0 || u.getDireccion().equals("")) {

            return "redirect:/user/mostrarFormMas";


        }

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


                servCarrito.deleteCarritoByUsuario(u);
                u.setVenta(servTienda.generaFactura(v));


                producer.sendMessage2(u);
            }


        return "redirect:/inicio";
        }


    }





    

