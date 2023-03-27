package com.AlvaroyRaul.PcPiezas.kafka;


import com.AlvaroyRaul.PcPiezas.kafka.entity.simplifiedVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class sendVenta {

    private static final String TOPIC_NAME = "ventaMail";

    @Autowired
    private KafkaTemplate<String, simplifiedVenta> kafkaTemplate;

    public void sendMessage() {
        simplifiedVenta vToSend = new simplifiedVenta("Hola");
        //simplifiedVenta vToSend = new simplifiedVenta(v.getId(), v.getDirEnvio(), v.getTotal(), v.getFechaCompra(), v.getListaItems(), v.getComprador());
        kafkaTemplate.send(TOPIC_NAME, vToSend);
    }
}
