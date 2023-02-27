package com.AlvaroyRaul.PcPiezas.controllers;

import com.AlvaroyRaul.PcPiezas.database.entity.carrito;
import com.AlvaroyRaul.PcPiezas.database.entity.producto;
import com.AlvaroyRaul.PcPiezas.database.entity.usuario;
import com.AlvaroyRaul.PcPiezas.database.repository.usuarioRepo;
import com.AlvaroyRaul.PcPiezas.servicies.servicioCarrito;
import com.AlvaroyRaul.PcPiezas.database.repository.carritoRepo;
import org.mockito.internal.matchers.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@Controller
public class carritoController {
    @Autowired
    private servicioCarrito servCarrito;
    @Autowired
    private carritoRepo carritRepo;
    @Autowired
    private usuarioRepo userRepo;


    @GetMapping("/listaCarrito")
    public String verCarrito(Model model) {

        List<producto> listaProductosCarrito = servCarrito.getAllProductInCarrito();
        model.addAttribute("productos", listaProductosCarrito);
        return "shopping_cart";
    }
    @GetMapping("/AddToCart/{id}")//Solo funciona con GET idk
    public String anadirACarrito(@PathVariable("id") long id) {


        servCarrito.saveProductoEnCarrito(id);

        return "redirect:/listaCarrito";

    }
    @GetMapping("/DeleteFromCarrito/{id}")
    public String borrarDelCarrito(@PathVariable("id") long id) {


        servCarrito.deleteProductoInCarritoById(id);

        return "redirect:/listaCarrito";

    }

}
