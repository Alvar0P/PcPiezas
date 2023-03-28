package com.AlvaroyRaul.PcPiezas.controllers;


import com.AlvaroyRaul.PcPiezas.database.entity.Usuario;
import com.AlvaroyRaul.PcPiezas.database.repository.UsuarioRepo;
import com.AlvaroyRaul.PcPiezas.publisher.RabbitMQProducer;

import com.AlvaroyRaul.PcPiezas.servicies.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class MessageController {

    private RabbitMQProducer producer;
    @Autowired
    private ServicioUsuario servicioUsuario;
    @Autowired
    private UsuarioRepo usuarioRepo;



    public MessageController(RabbitMQProducer producer) {
        this.producer = producer;
    }


    @PostMapping("/addU")
    public void guardarCliente(HttpServletResponse response, @RequestParam("username") String username, @RequestParam("email") String email,
                                 @RequestParam("password") String pass) throws IOException {

        servicioUsuario.saveClientToDB(username,email,pass);
        Usuario u = usuarioRepo.findByUsername(username);

        //producer.sendMessage(u);



        response.sendRedirect("/inicio");

    }



}
