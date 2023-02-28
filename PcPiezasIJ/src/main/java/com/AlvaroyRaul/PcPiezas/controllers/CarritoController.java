package com.AlvaroyRaul.PcPiezas.controllers;

import com.AlvaroyRaul.PcPiezas.database.entity.Producto;
import com.AlvaroyRaul.PcPiezas.database.repository.UsuarioRepo;
import com.AlvaroyRaul.PcPiezas.servicies.ServicioCarrito;
import com.AlvaroyRaul.PcPiezas.database.repository.CarritoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@Controller
public class CarritoController {
    @Autowired
    private ServicioCarrito servCarrito;
    @Autowired
    private CarritoRepo carritRepo;
    @Autowired
    private UsuarioRepo userRepo;


    @GetMapping("/listaCarrito")
    public String verCarrito(Model model) {

        List<Producto> listaProductosCarrito = servCarrito.getAllProductInCarrito();
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
