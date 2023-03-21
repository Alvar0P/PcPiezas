package com.AlvaroyRaul.PcPiezas.controllers;

import com.AlvaroyRaul.PcPiezas.database.repository.UsuarioRepo;
import com.AlvaroyRaul.PcPiezas.servicies.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class RegistroController {

    @Autowired
    private UsuarioRepo usuarioRepo;
    @Autowired
    private ServicioUsuario servicioUsuario;


    @PostMapping("/addU")
    public String guardarProducto(@RequestParam("username") String username, @RequestParam("email") String email,
                                  @RequestParam("pass") String pass) {

        servicioUsuario.saveClientToDB(username,email,pass);


        return "redirect:/inicio";

    }
}
