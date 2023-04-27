package com.AlvaroyRaul.PcPiezasMailService.consumer;

import com.AlvaroyRaul.PcPiezasMailService.dto.Item;
import com.AlvaroyRaul.PcPiezasMailService.dto.Usuario;
import com.AlvaroyRaul.PcPiezasMailService.dto.Venta;
import com.AlvaroyRaul.PcPiezasMailService.email.EmailService;
import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class RabbitMQJsonConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonConsumer.class);

    @Autowired
    private EmailService emailService;

    @RabbitListener(queues = {"${rabbitmq.queue.json.name}"})//Para Bienvenida
    public void consumeJson(Usuario user){
        Usuario u = new Usuario();
        u.setIdUsuario(user.getIdUsuario());
        u.setUsername(user.getUsername());
        u.setPassword(u.getPassword());
        u.setEmail(user.getEmail());

        String Subeject = "¡Bienvenido!";
        String email = u.getEmail();
        String msg = "Hola "+u.getUsername()+" ,\n ¡Gracias por confiar en nosotros!";
        emailService.sendSimpleMessage(email,Subeject,msg);

        LOGGER.info(String.format("Received JSON message -> %s",user.toString()));
    }

    @RabbitListener(queues = {"${rabbitmq.queue2.json.name}"})//Para Venta
    public void consumeJson2(Usuario user){

        Usuario u = new Usuario();
        u.setUsername(user.getUsername());
        u.setEmail(user.getEmail());
        u.setVenta(user.getVenta());
        String Subeject = "Recibo de compra";
        String email =u.getEmail();
        String msg ="Hola!, aquí tienes tu recibo de compra.\n"+ u.getVenta();


        emailService.sendSimpleMessage(email,Subeject,msg);

        LOGGER.info(String.format("Received JSON message -> %s",user.toString()));
    }


}
