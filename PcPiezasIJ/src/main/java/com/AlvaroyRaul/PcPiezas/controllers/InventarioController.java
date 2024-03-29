package com.AlvaroyRaul.PcPiezas.controllers;

import com.AlvaroyRaul.PcPiezas.database.entity.Item;
import com.AlvaroyRaul.PcPiezas.database.entity.Producto;
import com.AlvaroyRaul.PcPiezas.database.entity.Usuario;
import com.AlvaroyRaul.PcPiezas.database.repository.ItemRepo;
import com.AlvaroyRaul.PcPiezas.database.repository.ProductoRepo;
import com.AlvaroyRaul.PcPiezas.database.repository.UsuarioRepo;
import com.AlvaroyRaul.PcPiezas.servicies.ServicioItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class InventarioController {
    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private ProductoRepo productoRepo;
    @Autowired
    private ServicioItem sItem;
    @Autowired
    private UsuarioRepo usuarioRepo;
    @GetMapping("/listaItems")
    public String verListaItems(HttpServletRequest request, Model model) {

        List<Item> listaItems = sItem.getAllItemsInStock();
        List<Producto> listaProductos = new ArrayList<Producto>();
        Usuario u = usuarioRepo.findByUsername(request.getUserPrincipal().getName());
        if (u.getRol().equals("ADMINISTRADOR")){
            for(Item itemP : listaItems) {
                listaProductos.add(itemP.getProducto());
            }
        }else {
           listaItems =  sItem.getItemsSellers(u);
        }



        model.addAttribute("nombreProducto","");
        model.addAttribute("productos", listaProductos);
        model.addAttribute("items", listaItems);
        return "listItems";



    }
    @GetMapping("/listaItems(id={id})")
    public String verListaItemsParaProducto(Model model, @PathVariable long id) {

        List<Item> listaItems = sItem.getAllItemsInStockForProduct(id);
        List<Producto> listaProductos = new ArrayList<Producto>();
        for(Item itemP : listaItems) {
            listaProductos.add(itemP.getProducto());
        }
        if(listaProductos.size() != 0) {
            model.addAttribute("nombreProducto", listaProductos.get(0).getFabricante() + " " + listaProductos.get(0).getNombre());
            model.addAttribute("productos", listaProductos);
            model.addAttribute("items", listaItems);
        }
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
        Producto pItem = productoRepo.findById(productoId).get();
        Item itemNuevo = new Item(nSerie, pItem);
        itemRepo.save(itemNuevo);
        return "redirect:/admin/listaItems";

    }
    @GetMapping("/deleteItem/{nSerie}")
    public String deleteItem(@PathVariable String nSerie)
    {
        itemRepo.deleteById(nSerie);

        return "redirect:/admin/listaItems";
    }

}