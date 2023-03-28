package com.AlvaroyRaul.PcPiezas.rabbitMQConfig;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {


    @Value("${rabbitmq.queue.json.name}")//Para benvenida
    private String queue;
    @Value("${rabbitmq.queue2.json.name}")//Para venta
    private String queue2;
    @Value("${rabbitmq.exchange.name}")
    private String exchange;
    @Value("${rabbitmq.routing.json.key}")//Para bienvenida
    private String routingJsonKey;
    @Value("${rabbitmq.routing.json.key2}")//Para venta
    private String routingJsonKey2;

    @Bean//Para bienvenida
    public Queue jsonqueue(){
        return new Queue(queue);
    }
    @Bean//Para venta
    public Queue jsonqueue2(){
        return new Queue(queue2);
    }
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(exchange);
    }

    @Bean//Para bienvenida
    public Binding jsonbinding(){

        return BindingBuilder.bind(jsonqueue()).to(exchange()).with(routingJsonKey);
    }
    @Bean//Para venta
    public Binding jsonbinding2(){

        return BindingBuilder.bind(jsonqueue2()).to(exchange()).with(routingJsonKey2);
    }
    @Bean
    public MessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory){

        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;

    }

}
