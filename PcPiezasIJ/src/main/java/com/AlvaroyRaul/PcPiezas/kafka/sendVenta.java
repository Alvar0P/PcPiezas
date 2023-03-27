package com.AlvaroyRaul.PcPiezas.kafka;


import com.AlvaroyRaul.PcPiezas.database.entity.Item;
import com.AlvaroyRaul.PcPiezas.database.entity.Venta;
import com.AlvaroyRaul.PcPiezas.kafka.entity.simplifiedItem;
import com.AlvaroyRaul.PcPiezas.kafka.entity.simplifiedVenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class sendVenta {

    private static final String TOPIC_NAME = "ventaMail";

    @Autowired
    private KafkaTemplate<String, simplifiedVenta> kafkaTemplate;

    public void sendMessage(Venta v) {
        List<simplifiedItem> listaItems = new ArrayList<>();
        for(Item i : v.getListaItems()) {
            listaItems.add(new simplifiedItem(i.getnSerie(), i.getProducto().getFabricante(), i.getProducto().getNombre(), i.getProducto().getDescripcion(), i.getProducto().getCategoria(), i.getProducto().getPrecio()));
        }
        simplifiedVenta vToSend = new simplifiedVenta(v.getId(), v.getDirEnvio(), v.getTotal(), v.getFechaCompra(), listaItems, v.getComprador().getUsername());
        kafkaTemplate.send(TOPIC_NAME, vToSend);
    }
}
