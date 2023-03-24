package com.AlvaroyRaul.PcPiezas.controllers;

import com.AlvaroyRaul.PcPiezas.database.entity.Producto;
import com.AlvaroyRaul.PcPiezas.database.entity.Usuario;
import com.AlvaroyRaul.PcPiezas.database.repository.ProductoRepo;
import com.AlvaroyRaul.PcPiezas.servicies.ServicioCarrito;
import com.AlvaroyRaul.PcPiezas.servicies.ServicioItem;
import com.AlvaroyRaul.PcPiezas.servicies.ServicioProducto;
import com.AlvaroyRaul.PcPiezas.servicies.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class ProductosController {

    public class productosLista extends Producto {
        long cantidadStock;

        public productosLista(Producto p, long stock){
            super(p);
            this.cantidadStock = stock;
        }

        public long getCantidadStock() {
            return cantidadStock;
        }
    }
    @Autowired
    private ServicioProducto servicioProduct;
    @Autowired
    private ServicioUsuario servU;
    @Autowired
    private ServicioItem servItem;
    @GetMapping("/listaProductos")
    public String verListaProductos(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Usuario currentUser = servU.getUserObject(authentication.getName());
        List<productosLista> listaProductos = new ArrayList<>();
        List<Producto> listaPTemp;
        if(currentUser.getRol().equals("ADMINISTRADOR")) {
            listaPTemp = servicioProduct.getAllProduct();
        }
        else {
            listaPTemp = servicioProduct.getProductsForSeller(currentUser);
        }
        for(Producto p : listaPTemp) {
            listaProductos.add(new productosLista(p, p.getStockProducto()));
        }
        model.addAttribute("productos", listaProductos);

        return "listProducts";
    }

    @GetMapping("/addProduct")
    public String registroProducto(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("vendedorU", authentication.getName());
        return "addProducto";
    }

    @PostMapping("/addP")
    @Transactional
    public String guardarProducto(@RequestParam("file") MultipartFile file, @RequestParam("name") String nombre,
                                  @RequestParam("desc") String descripcion, @RequestParam("fabri") String fabricante,
                                  @RequestParam("categoria") String categoria, @RequestParam("price") int precio) {


            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            servicioProduct.saveProductToDB(file,nombre,descripcion,fabricante,authentication.getName(),categoria,precio);





        return "redirect:/admin/listaProductos";

    }
    @GetMapping("/deleteProd/{id}")
    public String deleteProduct(@PathVariable long id)
    {

        servicioProduct.deleteProductById(id);
        return "redirect:/admin/listaProductos";
    }

    @PostMapping("/changeName/{id}")
    public String changePname(@PathVariable("id") Long id,
                              @RequestParam("newPname") String name)
    {
        servicioProduct.changeProductName(id, name);
        return "redirect:/admin/listaProductos";
    }
    @PostMapping("/changeDescription/{id}")
    public String changeDescription(@PathVariable("id") Long id ,
                                    @RequestParam("newDescription") String description)
    {
        servicioProduct.changeProductDescription(id, description);
        return "redirect:/admin/listaProductos";
    }

    @PostMapping("/changePrice/{id}")
    public String changePrice(@PathVariable("id") Long id ,
                              @RequestParam("newPrice") int price)
    {
        servicioProduct.changeProductPrice(id, price);
        return "redirect:/admin/listaProductos";
    }
    @PostMapping("/changeFabricante/{id}")
    public String changePrice(@PathVariable("id") Long id ,
                              @RequestParam("newFabricant") String Fabricante)
    {
        servicioProduct.changeProductFabricante(id, Fabricante);
        return "redirect:/admin/listaProductos";
    }

    @PostMapping("/changeCategoria/{id}")
    public String changeCategoria(@PathVariable("id") Long id ,
                              @RequestParam("newCategoria") String categoria)
    {
        servicioProduct.changeProductCategoria(id, categoria);
        return "redirect:/admin/listaProductos";
    }




}
