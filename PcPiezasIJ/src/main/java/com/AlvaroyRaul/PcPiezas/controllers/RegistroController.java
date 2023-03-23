package com.AlvaroyRaul.PcPiezas.controllers;

import com.AlvaroyRaul.PcPiezas.database.entity.Usuario;
import com.AlvaroyRaul.PcPiezas.database.repository.UsuarioRepo;
import com.AlvaroyRaul.PcPiezas.servicies.ServicioUsuario;
import com.google.inject.internal.Errors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegistroController {

    @Autowired
    private UsuarioRepo usuarioRepo;
    @Autowired
    private ServicioUsuario servicioUsuario;

    @GetMapping("/register")
    public String formularioRegistro() {


        return "registerClient";
    }
    /*
    @PostMapping("/addU")
    public String registroCliente(@ModelAttribute("user") Usuario user) {



             servicioUsuario.saveClienteToDB(user);


            return "reditect:/login";


    }*/

    @GetMapping("/addU")
    public String guardarCliente(@RequestParam("username") String username, @RequestParam("email") String email,
                                  @RequestParam("password") String pass) {

        servicioUsuario.saveClientToDB(username,email,pass);


        return "/login";

    }
}
