package com.AlvaroyRaul.PcPiezas;
import com.AlvaroyRaul.PcPiezas.Database.Repository.usuarioRepo;
import com.AlvaroyRaul.PcPiezas.Database.Entity.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/usuarios") // This means URL's start with /demo (after Application path)
public class pruebaControladorUsuarios {
    @Autowired
    private usuarioRepo usuarioRepo;

    @PostMapping(path = "/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUser(@RequestParam String name
            , @RequestParam String email, @RequestParam String password) {


        usuario n = new usuario(name,email, password);
        usuarioRepo.save(n);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<usuario> getAllUsers() {
        // This returns a JSON or XML with the users
        return usuarioRepo.findAll();
    }
}