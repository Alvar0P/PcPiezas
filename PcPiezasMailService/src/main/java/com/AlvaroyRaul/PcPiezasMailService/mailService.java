package com.AlvaroyRaul.PcPiezasMailService;

import com.AlvaroyRaul.PcPiezasMailService.entity.Venta;
import org.springframework.kafka.annotation.KafkaListener;

public class mailService {
    @KafkaListener(topics = "${kafka.topic.name}")
    public void listener(Venta v) {
        System.out.println("Cantidad:" + v.getTotal());
    }

}
