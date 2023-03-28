package com.AlvaroyRaul.PcPiezas.publisher;

import com.AlvaroyRaul.PcPiezas.database.entity.Usuario;


import com.AlvaroyRaul.PcPiezas.database.entity.Venta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducer {
/*
    @Value("${rabbitmq.exchange.name}")
    private String exchange;
    @Value("${rabbitmq.routing.json.key}")//Para bienvenida
    private String routingKey;
    @Value("${rabbitmq.routing.json.key2}")//Para venta
    private String routingKey2;

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQProducer.class);

    private RabbitTemplate rabbitTemplate;


    public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(Usuario usuario){


        LOGGER.info(String.format("Message sent -> %s",usuario.toString()));
        rabbitTemplate.convertAndSend(exchange,routingKey,usuario);

    }

    public void sendMessage2(Usuario usuario){

        //LOGGER.info(String.format("Message sent -> %s",usuario.toString()));
        rabbitTemplate.convertAndSend(exchange,routingKey2,usuario);

    }

 */
}
