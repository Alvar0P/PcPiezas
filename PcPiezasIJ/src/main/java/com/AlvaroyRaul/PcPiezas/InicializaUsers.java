package com.AlvaroyRaul.PcPiezas;

import com.AlvaroyRaul.PcPiezas.database.entity.Carrito;
import com.AlvaroyRaul.PcPiezas.database.entity.Rol;
import com.AlvaroyRaul.PcPiezas.database.entity.Usuario;
import com.AlvaroyRaul.PcPiezas.database.repository.CarritoRepo;
import com.AlvaroyRaul.PcPiezas.database.repository.ProductoRepo;
import com.AlvaroyRaul.PcPiezas.database.repository.UsuarioRepo;

import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

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

    public static Carrito carr;
    public static Usuario admin;
    public static Usuario comprador;
    public static Usuario vendedor;

    @Override
    public void run(String... args) throws Exception {
        if(args.length >= 1) {
            if(args[0].equalsIgnoreCase("buildUsers")) {
                admin = new Usuario();
                admin.anadirUser("PcPiezas","admin@pcpiezas.es", "12345", Rol.ADMINISTRADOR);
                userRepo.save(admin);

                comprador = new Usuario();
                comprador.anadirUser("Juan", "juan@gmail.com", "12345", Rol.COMPRADOR);
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

                vendedor = new Usuario();
                vendedor.anadirUser("Pro1Performance", "ramon@pro1performance.com", "12345", Rol.VENDEDOR);
                userRepo.save(vendedor);





            }}
    }
}
