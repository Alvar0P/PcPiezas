package com.AlvaroyRaul.PcPiezas.controllers;

import com.AlvaroyRaul.PcPiezas.database.entity.producto;
import com.AlvaroyRaul.PcPiezas.database.repository.productoRepo;
import com.AlvaroyRaul.PcPiezas.database.repository.usuarioRepo;
import com.AlvaroyRaul.PcPiezas.servicioProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Controller
public class productosController {
    @Autowired
    private productoRepo productoRepo;
    @Autowired
    private servicioProducto servicioProduct;
    @GetMapping("/productos")
    public String productos(Model model) {
        List<producto> listaProductos = new ArrayList<>();

        model.addAttribute("productos", productoRepo.findAll());
        return "productos_prueba";
    }
    @PostMapping("/addP")
    public String guardarProducto(@RequestParam("file") MultipartFile file,@RequestParam("name") String nombre,
                             @RequestParam("desc") String descripcion,@RequestParam("fabri") String fabricante,
                             @RequestParam("price") int precio) {

        servicioProduct.saveProductToDB(file,nombre,descripcion,fabricante,precio);

        return "/lista";

}}
