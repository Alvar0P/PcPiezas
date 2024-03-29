package com.AlvaroyRaul.PcPiezas.controllers;

import com.AlvaroyRaul.PcPiezas.database.entity.Producto;
import com.AlvaroyRaul.PcPiezas.database.entity.Usuario;
import com.AlvaroyRaul.PcPiezas.database.repository.CarritoRepo;
import com.AlvaroyRaul.PcPiezas.database.repository.UsuarioRepo;
import com.AlvaroyRaul.PcPiezas.servicies.ServicioCarrito;
import com.AlvaroyRaul.PcPiezas.servicies.ServicioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class MustacheController {
    @Autowired
    private ServicioProducto servicioProduct;
    @Autowired
    private ServicioCarrito servCarrito;
    @Autowired
    private CarritoRepo carritoRepo;
    @Autowired
    private UsuarioRepo userRep;

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
        List<Producto> listaProductos = servicioProduct.getProductoPorCategoria("Ordenadores");
        model.addAttribute("productos", listaProductos);

        return "ordenadores";
    }
    @GetMapping("/componentes")
    public String componentes(Model model) {
        List<Producto> listaProductos = servicioProduct.getProductoPorCategoria("Componentes");
        model.addAttribute("productos", listaProductos);

        return "componentes";
    }
    @GetMapping("/moviles")
    public String moviles(Model model) {
        List<Producto> listaProductos = servicioProduct.getProductoPorCategoria("Movil");
        model.addAttribute("productos", listaProductos);

        return "moviles";
    }
    @GetMapping("/perifericos")
    public String perifericos(Model model) {
        List<Producto> listaProductos = servicioProduct.getProductoPorCategoria("Perifericos");
        model.addAttribute("productos", listaProductos);

        return "perifericos";
    }

    @GetMapping("/contacto")
    public String contacto(Model model) {


        return "contact";
    }




}

