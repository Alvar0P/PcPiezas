package com.AlvaroyRaul.PcPiezas.controllers;

import com.AlvaroyRaul.PcPiezas.database.entity.item;
import com.AlvaroyRaul.PcPiezas.database.entity.producto;
import com.AlvaroyRaul.PcPiezas.database.repository.itemRepo;
import com.AlvaroyRaul.PcPiezas.database.repository.productoRepo;
import com.AlvaroyRaul.PcPiezas.servicies.servicioItem;
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
public class inventarioController {
    @Autowired
    private itemRepo itemRepo;
    @Autowired
    private servicioItem sItem;
    @GetMapping("/listaItems")
    public String verListaItems(Model model) {

        List<item> listaItems = sItem.getAllItems();
        List<producto> listaProductos = new ArrayList<producto>();
        for(item itemP : listaItems) {
            listaProductos.add(itemP.getProducto());
        }
        model.addAttribute("productos", listaProductos);
        model.addAttribute("items", listaItems);
        return "listInventario";
    }
    @PostMapping("/addItem")
    public String guardarItem(@RequestParam("file") MultipartFile file,@RequestParam("name") String nombre,
                                  @RequestParam("desc") String descripcion,@RequestParam("fabri") String fabricante,@RequestParam("vendedor") String vendedor,//Todo cambiar por "usuario vendedor" al final
                                  @RequestParam("price") int precio) {



        return "";

    }
    @GetMapping("/deleteItem/{nSerie}")
    public String deleteItem(@PathVariable long id)
    {


        return "";
    }

}
