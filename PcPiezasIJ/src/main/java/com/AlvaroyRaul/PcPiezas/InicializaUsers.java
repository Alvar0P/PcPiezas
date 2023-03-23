package com.AlvaroyRaul.PcPiezas;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.AlvaroyRaul.PcPiezas.database.entity.Carrito;
import com.AlvaroyRaul.PcPiezas.database.entity.Usuario;
import com.AlvaroyRaul.PcPiezas.database.repository.CarritoRepo;
import com.AlvaroyRaul.PcPiezas.database.repository.ProductoRepo;
import com.AlvaroyRaul.PcPiezas.database.repository.UsuarioRepo;

import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Order(1)
public class InicializaUsers implements CommandLineRunner {
    @Autowired
    private UsuarioRepo userRepo;
    @Autowired
    private ProductoRepo productRepo;
    @Autowired
    private CarritoRepo carritRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public static Carrito carr;
    public static Usuario admin;
    public static Usuario comprador;
    public static Usuario vendedor;

    @Override
    public void run(String... args) throws Exception {
        if(args.length >= 1) {
            if(args[0].equalsIgnoreCase("buildUsers")) {
                admin = new Usuario();
                admin.anadirUser("PcPiezas","admin@pcpiezas.es", passwordEncoder.encode("12345"), "ADMINISTRADOR");
                userRepo.save(admin);


                comprador = new Usuario();
                comprador.anadirUser("Juan", "juan@gmail.com", passwordEncoder.encode("12345"), "COMPRADOR");
                userRepo.save(comprador);


                vendedor = new Usuario();
                vendedor.anadirUser("Pro1Performance", "ramon@pro1performance.com", passwordEncoder.encode("12345"), "VENDEDOR");
                userRepo.save(vendedor);





            }}
    }
}
