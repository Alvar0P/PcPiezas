package com.AlvaroyRaul.PcPiezas.controllers;

import com.AlvaroyRaul.PcPiezas.database.entity.Producto;
import com.AlvaroyRaul.PcPiezas.database.repository.ProductoRepo;
import com.AlvaroyRaul.PcPiezas.servicies.ServicioCarrito;
import com.AlvaroyRaul.PcPiezas.servicies.ServicioItem;
import com.AlvaroyRaul.PcPiezas.servicies.ServicioProducto;
import org.springframework.beans.factory.annotation.Autowired;
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
    private ProductoRepo productoRepo;
    @Autowired
    private ServicioProducto servicioProduct;
    @Autowired
    private ServicioCarrito servCarrito;
    @Autowired
    private ServicioItem servItem;
    @GetMapping("/admin/listaProductos")
    public String verListaProductos(Model model) {
        List<productosLista> listaProductos = new ArrayList<>();
        for(Producto p : servicioProduct.getAllProduct()) {
            listaProductos.add(new productosLista(p, p.getStockProducto()));
        }
        model.addAttribute("productos", listaProductos);

        return "listProducts";
    }


    @PostMapping("/admin/addP")
    @Transactional
    public String guardarProducto(@RequestParam("file") MultipartFile file, @RequestParam("name") String nombre,
                                  @RequestParam("desc") String descripcion, @RequestParam("fabri") String fabricante, @RequestParam("vendedor") String vendedor,
                                  @RequestParam("categoria") String categoria, @RequestParam("price") int precio) {



            servicioProduct.saveProductToDB(file,nombre,descripcion,fabricante,vendedor,categoria,precio);





        return "/admin/listProducts";

    }
    @GetMapping("/admin/deleteProd/{id}")
    public String deleteProduct(@PathVariable long id)
    {

        servicioProduct.deleteProductById(id);
        return "redirect:/admin/listaProductos";
    }

    @PostMapping("/admin/changeName/{id}")
    public String changePname(@PathVariable("id") Long id,
                              @RequestParam("newPname") String name)
    {
        servicioProduct.changeProductName(id, name);
        return "redirect:/admin/listaProductos";
    }
    @PostMapping("/admin/changeDescription/{id}")
    public String changeDescription(@PathVariable("id") Long id ,
                                    @RequestParam("newDescription") String description)
    {
        servicioProduct.changeProductDescription(id, description);
        return "redirect:/admin/listaProductos";
    }

    @PostMapping("/admin/changePrice/{id}")
    public String changePrice(@PathVariable("id") Long id ,
                              @RequestParam("newPrice") int price)
    {
        servicioProduct.changeProductPrice(id, price);
        return "redirect:/admin/listaProductos";
    }
    @PostMapping("/admin/changeFabricante/{id}")
    public String changePrice(@PathVariable("id") Long id ,
                              @RequestParam("newFabricant") String Fabricante)
    {
        servicioProduct.changeProductFabricante(id, Fabricante);
        return "redirect:/admin/listaProductos";
    }

    @PostMapping("/admin/changeCategoria/{id}")
    public String changeCategoria(@PathVariable("id") Long id ,
                              @RequestParam("newCategoria") String categoria)
    {
        servicioProduct.changeProductCategoria(id, categoria);
        return "redirect:/admin/listaProductos";
    }




}
