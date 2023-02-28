package com.AlvaroyRaul.PcPiezas.controllers;

import com.AlvaroyRaul.PcPiezas.database.entity.Producto;
import com.AlvaroyRaul.PcPiezas.database.entity.Usuario;
import com.AlvaroyRaul.PcPiezas.database.repository.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
@Controller
public class LogicaTiendaController {
    @Autowired
    private UsuarioRepo userRepo;
    /*
    @GetMapping("/compra/{id}")//id del carrito
    public String checkOut(Model model) {

        Usuario u = new Usuario();
        u = userRepo.findById((long)2).get();//Prueba
        List<Producto> listaProductos = new ArrayList<>();
        listaProductos = u.getCarrito().getProductos();

        model.addAttribute("stockProductos", stockProductos);
        model.addAttribute("productos", listaProductos);

        return "Shopping_cart";
    }*/


    
}
