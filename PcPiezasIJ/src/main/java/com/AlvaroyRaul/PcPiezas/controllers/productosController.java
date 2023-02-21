package com.AlvaroyRaul.PcPiezas.controllers;

import com.AlvaroyRaul.PcPiezas.database.entity.producto;
import com.AlvaroyRaul.PcPiezas.database.repository.productoRepo;
import com.AlvaroyRaul.PcPiezas.database.repository.usuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class productosController {
    @Autowired
    private productoRepo productoRepo;
    @GetMapping("/productos")
    public String productos(Model model) {
        List<producto> listaProductos = new ArrayList<>();

        model.addAttribute("productos", productoRepo.findAll());
        return "productos_prueba";
    }
    @PostMapping("/nuevo-producto")
    public String submitForm(@RequestParam("fabricante") String fabricante,
                                           @RequestParam("nombre") String nombre,
                                           @RequestParam("precio") int precio) {
        producto nuevoProducto = new producto(fabricante, "PcPiezas", nombre, "", 0, precio);
        productoRepo.save(nuevoProducto);
        return "productos_prueba";

}}
