package com.AlvaroyRaul.PcPiezas.controllers;

import com.AlvaroyRaul.PcPiezas.database.entity.producto;
import com.AlvaroyRaul.PcPiezas.servicies.servicioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class MustacheController {
    @Autowired
    private servicioProducto servicioProduct;

    @GetMapping("/login")
    public String login(Model model) {


        return "login";
    }

    @GetMapping("/inicio")
    public String inicio(Model model) {


        return "inicio";
    }
    @GetMapping("/ordenadores")
    public String pcs(Model model) {


        return "ordenadores";
    }
    @GetMapping("/componentes")
    public String componentes(Model model) {
        List<producto> listaProductos = servicioProduct.getAllProduct();
        model.addAttribute("productos", listaProductos);

        return "componentes";
    }
    @GetMapping("/moviles")
    public String moviles(Model model) {


        return "moviles";
    }
    @GetMapping("/perifericos")
    public String perifericos(Model model) {


        return "perifericos";
    }
    @GetMapping("/carrito")
    public String carrito(Model model) {


        return "shopping_cart";
    }
    @GetMapping("/contacto")
    public String contacto(Model model) {


        return "contact";
    }
    @GetMapping("/register")
    public String registroCliente(Model model){
        return "registerClient";
    }
    @GetMapping("/addProduct")
    public String registroProducto(Model model){return "addProducto";}
    //@GetMapping("/listaProductos")
    //public String lista(Model model){return "listProducts";}


}

