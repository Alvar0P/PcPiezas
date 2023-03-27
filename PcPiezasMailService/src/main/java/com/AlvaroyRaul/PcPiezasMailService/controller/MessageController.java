package com.AlvaroyRaul.PcPiezasMailService.controller;

import com.AlvaroyRaul.PcPiezasMailService.consumer.RabbitMQJsonConsumer;
import com.AlvaroyRaul.PcPiezasMailService.dto.Usuario;
import com.AlvaroyRaul.PcPiezasMailService.email.EmailService;
import com.AlvaroyRaul.PcPiezasMailService.publisher.RabbitMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mail")
public class MessageController {

    private RabbitMQProducer producer;

    @Autowired
    private EmailService emailService;

    public MessageController(RabbitMQProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestBody Usuario user){
        producer.sendMessage(user);

        Usuario u = new Usuario();
        u.setIdUsuario(user.getIdUsuario());
        u.setUsername(user.getUsername());
        u.setPassword(u.getPassword());
        u.setEmail(user.getEmail());

        String Subeject = "Prueba email";
        String email = u.getEmail();
        String msg = "Hola "+u.getUsername()+" la prueba email";
        emailService.sendSimpleMessage(email,Subeject,msg);

        return new ResponseEntity<>("Email mandado con exito", HttpStatus.CREATED);


    }



}
