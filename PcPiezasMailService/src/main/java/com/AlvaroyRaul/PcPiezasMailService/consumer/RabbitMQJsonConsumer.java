package com.AlvaroyRaul.PcPiezasMailService.consumer;

import com.AlvaroyRaul.PcPiezasMailService.dto.Usuario;
import com.AlvaroyRaul.PcPiezasMailService.email.EmailService;
import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonConsumer.class);

    @Autowired
    private EmailService emailService;

    @RabbitListener(queues = {"${rabbitmq.queue.json.name}"})
    public void consumeJson(Usuario user){
        Usuario u = new Usuario();
        u.setIdUsuario(user.getIdUsuario());
        u.setUsername(user.getUsername());
        u.setPassword(u.getPassword());
        u.setEmail(user.getEmail());

        String Subeject = "Prueba email";
        String email = u.getEmail();
        String msg = "Hola "+u.getUsername()+" la prueba email";
        emailService.sendSimpleMessage(email,Subeject,msg);

        LOGGER.info(String.format("Received JSON message -> %s",user.toString()));
    }
}
