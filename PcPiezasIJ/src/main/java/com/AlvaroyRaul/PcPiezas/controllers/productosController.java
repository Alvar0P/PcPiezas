package com.AlvaroyRaul.PcPiezas.controllers;

import com.AlvaroyRaul.PcPiezas.database.entity.producto;
import com.AlvaroyRaul.PcPiezas.database.repository.productoRepo;
import com.AlvaroyRaul.PcPiezas.servicies.servicioCarrito;
import com.AlvaroyRaul.PcPiezas.servicies.servicioItem;
import com.AlvaroyRaul.PcPiezas.servicies.servicioProducto;
import com.google.common.net.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class productosController {
    @Autowired
    private productoRepo productoRepo;
    @Autowired
    private servicioProducto servicioProduct;
    @Autowired
    private servicioCarrito servCarrito;
    @Autowired
    private servicioItem servItem;
    @GetMapping("/listaProductos")
    public String verListaProductos(Model model) {
        List<Long> stockProductos = new ArrayList<Long>();
        List<producto> listaProductos = servicioProduct.getAllProduct();
        for(producto p : listaProductos) {
            stockProductos.add(servItem.getItemCountForProduct(p.getIdProducto()));
        }
        model.addAttribute("stockProductos", stockProductos);
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

    @PostMapping("/changeName/{id}")
    public String changePname(@PathVariable("id") Long id,
                              @RequestParam("newPname") String name)
    {
        servicioProduct.changeProductName(id, name);
        return "redirect:/listaProductos";
    }
    @PostMapping("/changeDescription/{id}")
    public String changeDescription(@PathVariable("id") Long id ,
                                    @RequestParam("newDescription") String description)
    {
        servicioProduct.changeProductDescription(id, description);
        return "redirect:/listaProductos";
    }

    @PostMapping("/changePrice/{id}")
    public String changePrice(@PathVariable("id") Long id ,
                              @RequestParam("newPrice") int price)
    {
        servicioProduct.changeProductPrice(id, price);
        return "redirect:/listaProductos";
    }
    @PostMapping("/changeFabricante/{id}")
    public String changePrice(@PathVariable("id") Long id ,
                              @RequestParam("newFabricant") String Fabricante)
    {
        servicioProduct.changeProductFabricante(id, Fabricante);
        return "redirect:/listaProductos";
    }





}
