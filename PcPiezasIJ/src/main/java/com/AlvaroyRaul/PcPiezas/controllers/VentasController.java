package com.AlvaroyRaul.PcPiezas.controllers;

import com.AlvaroyRaul.PcPiezas.database.entity.Producto;
import com.AlvaroyRaul.PcPiezas.database.entity.Usuario;
import com.AlvaroyRaul.PcPiezas.database.entity.Venta;
import com.AlvaroyRaul.PcPiezas.database.repository.ProductoRepo;
import com.AlvaroyRaul.PcPiezas.servicies.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Controller
public class VentasController {
    @Autowired
    private ServicioVenta servicioVenta;
    @Autowired
    private ServicioUsuario servicioUsuario;
    @GetMapping("/admin/listaVentas")
    public String verListaVentas(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Usuario currentUser = servicioUsuario.getUserObject(authentication.getName());

        List<Venta> listaVentas;

        if(currentUser.getRol().equals("ADMINISTRADOR")) {
            listaVentas = servicioVenta.getAllVentas();

        }else if(currentUser.getRol().equals("COMPRADOR")) {

            listaVentas = servicioVenta.getVentasForBuyers(currentUser);
        }else{
            listaVentas = servicioVenta.getVentasForSellers(currentUser);
        }
        model.addAttribute("ventas", listaVentas);

        return "listVentas";
    }




}
