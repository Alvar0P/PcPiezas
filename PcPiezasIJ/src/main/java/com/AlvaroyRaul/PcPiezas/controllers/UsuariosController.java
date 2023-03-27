package com.AlvaroyRaul.PcPiezas.controllers;

import com.AlvaroyRaul.PcPiezas.database.entity.Producto;
import com.AlvaroyRaul.PcPiezas.database.entity.Usuario;
import com.AlvaroyRaul.PcPiezas.database.repository.UsuarioRepo;
import com.AlvaroyRaul.PcPiezas.publisher.RabbitMQProducer;
import com.AlvaroyRaul.PcPiezas.servicies.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UsuariosController {

    private RabbitMQProducer producer;
    @Autowired
    private UsuarioRepo usuarioRepo;
    @Autowired
    private ServicioUsuario servicioUsuario;
    @GetMapping("/registerVendedor")
    public String formularioRegistroVendedor(HttpServletRequest request) {
        if(request.getUserPrincipal() == null){
            return "registerVendedor";
        }

        return "redirect:/admin/listaVentas";
    }
    @PostMapping("/addUV")
    public String guardarVendedor(@RequestParam("username") String username, @RequestParam("email") String email,
                                 @RequestParam("password") String pass,@RequestParam("direccion")String direccion,@RequestParam("cuentaBancaria")String cuentaBancaria,@RequestParam("tlf")long tlf) {

        servicioUsuario.saveVendedorToDB(username,email,pass,direccion,cuentaBancaria,tlf);


        return "/inicio";

    }
    @GetMapping("/register")
    public String formularioRegistro(HttpServletRequest request) {
        if(request.getUserPrincipal() == null){
            return "registerClient";
        }

        return "redirect:/admin/listaVentas";
    }


    @PostMapping("/addU")
    public String guardarCliente(@RequestParam("username") String username, @RequestParam("email") String email,
                                  @RequestParam("password") String pass) {

        servicioUsuario.saveClientToDB(username,email,pass);
        Usuario u = usuarioRepo.findByUsername(username);

        producer.sendMessage(u);

        return "/inicio";

    }

    @GetMapping("/admin/usuarios/listaUsuarios")
    public String verListaProductos(Model model) {

        List<Usuario> listaU = new ArrayList<>();

        listaU = servicioUsuario.getAllUsers();

        model.addAttribute("usuarios", listaU);

        return "listUsers";
    }

    @GetMapping("/admin/usuarios/deleteUsuario/{id}")
    public String deleteUsuario(@PathVariable Long id)
    {

        servicioUsuario.deleteUsuarioById(id);
        return "redirect:/admin/usuarios/listaUsuarios";
    }
    @GetMapping("/user/mostrarFormMas")
    public String mostrarFormMas(){
        return "datosAdicionales";
    }

    @PostMapping("/user/addDatosA")
    public String datosAdicionales(HttpServletRequest request,@RequestParam("direccion")String direccion,@RequestParam("tarjeta")long tarjeta,@RequestParam("tlf")long tlf,@RequestParam("vip")boolean vip ){
        servicioUsuario.guardarDatosAdicionales(request,direccion,tarjeta,tlf,vip);
        return "redirect:/inicio";


    }
}
