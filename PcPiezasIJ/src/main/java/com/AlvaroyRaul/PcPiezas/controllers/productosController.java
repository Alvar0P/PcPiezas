package com.AlvaroyRaul.PcPiezas.controllers;

import com.AlvaroyRaul.PcPiezas.database.entity.producto;
import com.AlvaroyRaul.PcPiezas.database.repository.productoRepo;
import com.AlvaroyRaul.PcPiezas.servicies.servicioProducto;
import com.google.common.net.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;
import java.util.List;

@Controller
public class productosController {
    @Autowired
    private productoRepo productoRepo;
    @Autowired
    private servicioProducto servicioProduct;
    @GetMapping("/listaProductos")
    public String verListaProductos(Model model) {

        List<producto> listaProductos = servicioProduct.getAllProduct();
        model.addAttribute("productos", listaProductos);
        return "listProducts";
    }
    @PostMapping("/addP")
    public String guardarProducto(@RequestParam("file") MultipartFile file,@RequestParam("name") String nombre,
                             @RequestParam("desc") String descripcion,@RequestParam("fabri") String fabricante,@RequestParam("vendedor") String vendedor,//Todo cambiar por "usuario vendedor" al final
                             @RequestParam("price") int precio) {

        servicioProduct.saveProductToDB(file,nombre,descripcion,fabricante,vendedor,precio);

        return "redirect:/listaProductos";

    }
    @GetMapping("/deleteProd/{id}")
    public String deleteProduct(@PathVariable long id)
    {

        servicioProduct.deleteProductById(id);
        return "redirect:/listaProductos";
    }

    @PostMapping("/changeName")
    public String changePname(@RequestParam("id") Long id,
                              @RequestParam("newPname") String name)
    {
        servicioProduct.changeProductName(id, name);
        return "/listaProductos";
    }
    @PostMapping("/changeDescription")
    public String changeDescription(@RequestParam("id") Long id ,
                                    @RequestParam("newDescription") String description)
    {
        servicioProduct.changeProductDescription(id, description);
        return "/listaProductos";
    }

    @PostMapping("/changePrice")
    public String changePrice(@RequestParam("id") Long id ,
                              @RequestParam("newPrice") int price)
    {
        servicioProduct.changeProductPrice(id, price);
        return "/listaProductos";
    }





}
