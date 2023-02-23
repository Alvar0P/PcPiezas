package com.AlvaroyRaul.PcPiezas;

import com.AlvaroyRaul.PcPiezas.database.entity.rol;
import com.AlvaroyRaul.PcPiezas.database.entity.usuario;
import com.AlvaroyRaul.PcPiezas.database.repository.usuarioRepo;

import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
@Service
@Order(1)
public class inicializaUsers implements CommandLineRunner {
    @Autowired
    private usuarioRepo usuarioRepo;
    public static usuario admin;
    public static usuario comprador;
    public static usuario vendedor;

    @Override
    public void run(String... args) throws Exception {
        if(args.length >= 1) {
            if(args[0].equalsIgnoreCase("buildUsers")) {
                admin = new usuario("PcPiezas","admin@pcpiezas.es", "12345", rol.ADMINISTRADOR);
                usuarioRepo.save(admin);
                comprador = new usuario("Juan", "juan@gmail.com", "12345", rol.COMPRADOR);
                usuarioRepo.save(comprador);
                vendedor = new usuario("Pro1Performance", "ramon@pro1performance.com", "12345", rol.VENDEDOR);
                usuarioRepo.save(vendedor);

            }}
    }
}
