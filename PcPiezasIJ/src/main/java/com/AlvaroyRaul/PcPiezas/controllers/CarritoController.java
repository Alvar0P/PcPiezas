package com.AlvaroyRaul.PcPiezas.controllers;

import com.AlvaroyRaul.PcPiezas.database.entity.Carrito;
import com.AlvaroyRaul.PcPiezas.database.entity.Producto;
import com.AlvaroyRaul.PcPiezas.database.entity.Usuario;
import com.AlvaroyRaul.PcPiezas.database.repository.UsuarioRepo;
import com.AlvaroyRaul.PcPiezas.servicies.ServicioCarrito;
import com.AlvaroyRaul.PcPiezas.database.repository.CarritoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
@Controller
public class CarritoController {

    public class FilaCarrito extends Producto {
        public String  mensajeStock;

        public FilaCarrito(Producto producto, String mensajeStock) {
            super(producto);
            this.mensajeStock = mensajeStock;
        }

        public String getMensajeStock() {
            return mensajeStock;
        }
    }
    @Autowired
    private ServicioCarrito servCarrito;
    @Autowired
    private CarritoRepo carritRepo;
    @Autowired
    private UsuarioRepo userRepo;


    @GetMapping("/listaCarrito")
    public String verCarrito(Model model) {
        Usuario u = userRepo.findById((long)2).get();//Prueba
        if (u.getCarrito()==null){//
            Carrito c = new Carrito();//Unicamente hasta incluir los roles, la idea es que al hacer login se inicie uno.
            u.setCarrito(c);//
            List<Producto>productos = new ArrayList<>();
            c.setProductos(productos);
            carritRepo.save(c);
            userRepo.save(u);
        }//
        List<FilaCarrito> listaProductosCarrito = new ArrayList<>();
        for(Producto p : servCarrito.getAllProductInCarrito()) {
            String stock = "";
            if(p.getStockProducto() == 0) stock = "Este producto no se encuentra en stock. \n";
            else if(p.getStockProducto() < 2) stock = "Quedan pocas unidades en stock. \n";
            FilaCarrito fila = new FilaCarrito(p, stock);
            listaProductosCarrito.add(fila);
        }

        float subtotal = u.getCarrito().calcularSubtotal();
        model.addAttribute("subtotal",subtotal);
        model.addAttribute("productos", listaProductosCarrito);
        return "shopping_cart";
    }
    @GetMapping("/AddToCart/{id}")//Solo funciona con GET idk
    public String anadirACarrito(@PathVariable("id") long id) {


        servCarrito.saveProductoEnCarrito(id);

        return "redirect:/listaCarrito";

    }
    @GetMapping("/DeleteFromCarrito/{id}")
    public String borrarDelCarrito(@PathVariable("id") long id) {


        servCarrito.deleteProductoInCarritoById(id);

        return "redirect:/listaCarrito";

    }
    @GetMapping("/VaciarCarrito")
    public String vaciarCarrito(){
        servCarrito.vaciarCarritoByIdUsuario((long) 2);

        return "/listaCarrito";

    }

}
