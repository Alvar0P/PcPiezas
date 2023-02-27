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
    private productoRepo productoRepo;
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
        return "listItems";
    }

    @GetMapping("/addItem")
    public String verGuardarItem(Model model) {

        model.addAttribute("productos", productoRepo.findAll());
        return "addItem";
    }
    @PostMapping("/addI")
    public String guardarItem(@RequestParam("productoSeleccionado") long productoId,
                                  @RequestParam("nSerie") String nSerie) {
        /*producto = producto.replaceAll("\\D+","");
        long idProducto = Long.getLong(producto);*/
        producto pItem = productoRepo.findById(productoId).get();
        item itemNuevo = new item(nSerie, pItem);
        itemRepo.save(itemNuevo);
        return "redirect:/listaItems";

    }
    @GetMapping("/deleteItem/{nSerie}")
    public String deleteItem(@PathVariable String nSerie)
    {
        itemRepo.deleteById(nSerie);

        return "redirect:/listaItems";
    }

}
