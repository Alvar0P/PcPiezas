package com.AlvaroyRaul.PcPiezas.controllers;

import com.AlvaroyRaul.PcPiezas.database.entity.producto;
import com.AlvaroyRaul.PcPiezas.database.repository.usuarioRepo;
import com.AlvaroyRaul.PcPiezas.servicies.servicioCarrito;
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
    @Autowired
    private servicioCarrito servCarrito;
    @Autowired
    private usuarioRepo userRep;

    @GetMapping("/login")
    public String login(Model model) {


        return "login";
    }

    @GetMapping("/inicio")
    public String inicio(Model model) {
        /*
        for (int i=5;i<12;i++){
            servCarrito.deleteCarritoById(i);
        }//PRUEBAS*/
        //servCarrito.deleteCarritoById(11);
        //servCarrito.saveProductoEnCarrito((long)4);



        return "inicio";
    }
    @GetMapping("/ordenadores")
    public String pcs(Model model) {
        List<producto> listaProductos = servicioProduct.getProductoPorCategoria("Ordenadores");
        model.addAttribute("productos", listaProductos);

        return "ordenadores";
    }
    @GetMapping("/componentes")
    public String componentes(Model model) {
        List<producto> listaProductos = servicioProduct.getProductoPorCategoria("Componentes");
        model.addAttribute("productos", listaProductos);

        return "componentes";
    }
    @GetMapping("/moviles")
    public String moviles(Model model) {
        List<producto> listaProductos = servicioProduct.getProductoPorCategoria("Movil");
        model.addAttribute("productos", listaProductos);

        return "moviles";
    }
    @GetMapping("/perifericos")
    public String perifericos(Model model) {
        List<producto> listaProductos = servicioProduct.getProductoPorCategoria("Perifericos");
        model.addAttribute("productos", listaProductos);

        return "perifericos";
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

