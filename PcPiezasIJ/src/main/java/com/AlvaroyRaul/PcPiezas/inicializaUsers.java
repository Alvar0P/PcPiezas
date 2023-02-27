package com.AlvaroyRaul.PcPiezas;

import com.AlvaroyRaul.PcPiezas.database.entity.carrito;
import com.AlvaroyRaul.PcPiezas.database.entity.producto;
import com.AlvaroyRaul.PcPiezas.database.entity.rol;
import com.AlvaroyRaul.PcPiezas.database.entity.usuario;
import com.AlvaroyRaul.PcPiezas.database.repository.carritoRepo;
import com.AlvaroyRaul.PcPiezas.database.repository.productoRepo;
import com.AlvaroyRaul.PcPiezas.database.repository.usuarioRepo;

import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
@Order(1)
public class inicializaUsers implements CommandLineRunner {
    @Autowired
    private usuarioRepo userRepo;
    @Autowired
    private productoRepo productRepo;
    @Autowired
    private carritoRepo carritRepo;

    public static carrito carr;
    public static usuario admin;
    public static usuario comprador;
    public static usuario vendedor;

    @Override
    public void run(String... args) throws Exception {
        if(args.length >= 1) {
            if(args[0].equalsIgnoreCase("buildUsers")) {
                admin = new usuario();
                admin.anadirUser("PcPiezas","admin@pcpiezas.es", "12345", rol.ADMINISTRADOR);
                userRepo.save(admin);

                comprador = new usuario();
                comprador.anadirUser("Juan", "juan@gmail.com", "12345", rol.COMPRADOR);
                userRepo.save(comprador);
                /*
                carr = new carrito();
                carr.setUsuario(comprador);
                List<producto> productos = new ArrayList<>();
                carr.setProductos(productos);
                carritRepo.save(carr);
                comprador.setCarrito(carr);
                carritRepo.save(carr);
                userRepo.save(comprador);

                 */

                vendedor = new usuario();
                vendedor.anadirUser("Pro1Performance", "ramon@pro1performance.com", "12345", rol.VENDEDOR);
                userRepo.save(vendedor);





            }}
    }
}
