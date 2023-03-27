package com.AlvaroyRaul.PcPiezasMailService;

import com.AlvaroyRaul.PcPiezasMailService.kafkaEntity.simplifiedVenta;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class mailService {
    @KafkaListener(topics = "${kafka.topic.name}", groupId = "grupo")
    public void listener(simplifiedVenta v) {
        System.out.println("Cantidad:" + v.getTotal());
    }

}
